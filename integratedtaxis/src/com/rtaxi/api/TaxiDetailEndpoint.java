package com.rtaxi.api;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JDOCursorHelper;

@Api(name = "taxidetailendpoint", namespace = @ApiNamespace(ownerDomain = "rtaxi.com", ownerName = "rtaxi.com", packagePath = "api"))
public class TaxiDetailEndpoint {

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method and paging support.
	 * 
	 * @return A CollectionResponse class containing the list of all entities
	 *         persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listTaxiDetail")
	public CollectionResponse<TaxiDetail> listTaxiDetail(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit,
			@Nullable @Named("emailAddress") String emailAddress,
			@Nullable @Named("isPersonal") String isPersonal,
			@Nullable @Named("isCustomer") String isCustomer) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<TaxiDetail> execute = null;
		List<AgentDetail> executeAgent = null;
		String isAgent = "false";
		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(TaxiDetail.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			// if personal and email address is not null, display only his own
			// records
			if (isPersonal != null && isPersonal.equalsIgnoreCase("true")) {
				if (emailAddress != null && emailAddress != "") {
					query.setFilter("tclientemail==tclientemailParam ");
					query.declareParameters("String tclientemailParam");
					execute = (List<TaxiDetail>) query.execute(emailAddress);
				}
			} else { // IF AGENT THEN DISPLAYING IN THE AVAILABILITY LIST
				Query queryAgent = mgr.newQuery(AgentDetail.class);
				queryAgent.setFilter("tagentemail==tagentemailParam ");
				queryAgent.declareParameters("String tagentemailParam");
				executeAgent = (List<AgentDetail>) queryAgent
						.execute(emailAddress);
				if (executeAgent.isEmpty()) {
					isAgent = "false";
					query.setFilter("trecordtype!=trecordtypeParam ");
					query.declareParameters("String trecordtypeParam");
					execute = (List<TaxiDetail>) query.execute("cust");
				} else {
					isAgent = "true";
					String isPriority = "false";
					if (executeAgent.get(0).tagentpriority != null
							&& executeAgent.get(0).tagentpriority
									.equalsIgnoreCase("yes")) {
						execute = (List<TaxiDetail>) query.execute();
					} else {

						query.setFilter("trecordtype!=trecordtypeParam ");
						query.declareParameters("String trecordtypeParam");
						execute = (List<TaxiDetail>) query.execute("cust");

					}

				}
			}
			// execute = (List<TaxiDetail>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and
			// accomodate
			// for lazy fetch.
			for (TaxiDetail obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<TaxiDetail> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET
	 * method.
	 * 
	 * @param id
	 *            the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getTaxiDetail")
	public TaxiDetail getTaxiDetail(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		TaxiDetail taxidetail = null;
		try {
			taxidetail = mgr.getObjectById(TaxiDetail.class, id);
		} finally {
			mgr.close();
		}
		return taxidetail;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity
	 * already exists in the datastore, an exception is thrown. It uses HTTP
	 * POST method.
	 * 
	 * @param taxidetail
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertTaxiDetail")
	public TaxiDetail insertTaxiDetail(TaxiDetail taxidetail) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (taxidetail.getTrequestid() != null) {
				if (containsTaxiDetail(taxidetail)) {
					throw new EntityExistsException("Object already exists");
				}
			}
			mgr.makePersistent(taxidetail);
		} finally {
			mgr.close();
		}
		return taxidetail;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does
	 * not exist in the datastore, an exception is thrown. It uses HTTP PUT
	 * method.
	 * 
	 * @param taxidetail
	 *            the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateTaxiDetail")
	public TaxiDetail updateTaxiDetail(TaxiDetail taxidetail) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsTaxiDetail(taxidetail)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(taxidetail);
		} finally {
			mgr.close();
		}
		return taxidetail;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 * 
	 * @param id
	 *            the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeTaxiDetail")
	public void removeTaxiDetail(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			TaxiDetail taxidetail = mgr.getObjectById(TaxiDetail.class, id);
			mgr.deletePersistent(taxidetail);
		} finally {
			mgr.close();
		}
	}

	private boolean containsTaxiDetail(TaxiDetail taxidetail) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(TaxiDetail.class, taxidetail.getTrequestid());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}

}
