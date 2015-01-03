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

@Api(name = "agentdetailendpoint", namespace = @ApiNamespace(ownerDomain = "rtaxi.com", ownerName = "rtaxi.com", packagePath = ""))
public class AgentDetailEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listAgentDetail")
	public CollectionResponse<AgentDetail> listAgentDetail(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<AgentDetail> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(AgentDetail.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<AgentDetail>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (AgentDetail obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<AgentDetail> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getAgentDetail")
	public AgentDetail getAgentDetail(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		AgentDetail agentdetail = null;
		try {
			agentdetail = mgr.getObjectById(AgentDetail.class, id);
		} finally {
			mgr.close();
		}
		return agentdetail;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param agentdetail the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertAgentDetail")
	public AgentDetail insertAgentDetail(AgentDetail agentdetail) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (agentdetail.getTagentid() != null) {
			if (containsAgentDetail(agentdetail)) {
				throw new EntityExistsException("Object already exists");
			}
			}
			mgr.makePersistent(agentdetail);
		} finally {
			mgr.close();
		}
		return agentdetail;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param agentdetail the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateAgentDetail")
	public AgentDetail updateAgentDetail(AgentDetail agentdetail) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsAgentDetail(agentdetail)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(agentdetail);
		} finally {
			mgr.close();
		}
		return agentdetail;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeAgentDetail")
	public void removeAgentDetail(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			AgentDetail agentdetail = mgr.getObjectById(AgentDetail.class, id);
			mgr.deletePersistent(agentdetail);
		} finally {
			mgr.close();
		}
	}

	private boolean containsAgentDetail(AgentDetail agentdetail) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(AgentDetail.class, agentdetail.getTagentid());
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
