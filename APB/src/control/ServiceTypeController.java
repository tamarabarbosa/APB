/*
 * Package: Controller
 * Class: ServiceTypeController.java
 *
 * Description: This class is reponsible to inform to what job is done
 * atributes and necessary methods to attribute them.
 */

package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ServiceTypeDAO;
import model.ServiceType;

public class ServiceTypeController {

	// Stores the current instance of the class
	private static ServiceTypeController instance;

	/**
	 * Method that includes a new service type
	 * 
	 * @param serviceTypeToInclude
	 *            - Service type to be included
	 * @return if exists Service Type To Include
	 */
	public boolean insert(ServiceType typeJob) throws SQLException {
		boolean existsServiceTypeToInclude;
		if (typeJob == null) {
			existsServiceTypeToInclude = false;
		} else {
			ServiceTypeDAO serviceTypeDAOInstance = ServiceTypeDAO
					.getInstance();

			serviceTypeDAOInstance.insert(typeJob);
			existsServiceTypeToInclude = true;
		}
		return existsServiceTypeToInclude;
	}

	/**
	 * Method that modify a service type on the system
	 * 
	 * @param serviceTypeToNoChangeName
	 *            - Contains the name of the service type to change
	 * @param newServiceType
	 *            - New service type that will replace the old one on DB
	 * @return modifyServiceType - if exists modify Service Type
	 */
	public boolean change(String name, ServiceType typeJob) throws SQLException {
		boolean existsNewServiceType;
		if (typeJob == null) {
			existsNewServiceType = false;
		} else {
			// Auxiliary variable used to change the service type
			ServiceType changedServiceType = typeJob;

			ServiceTypeDAO serviceTypeDAOInstance = ServiceTypeDAO
					.getInstance();

			serviceTypeDAOInstance.change(existsNewServiceType,
					changedServiceType, typeJob);
			existsNewServiceType = true;
		}
		return existsNewServiceType;
	}

	/**
	 * Method that delete a service type on the system
	 * 
	 * @param serviceTypeToDelete
	 *            - Contains the service type to be deleted
	 * @return deleteServiceType - if exists service type to delete
	 */
	public boolean delete(ServiceType typeJob) throws SQLException {

		boolean existsServiceTypeToDelete;
		if (typeJob == null) {
			existsServiceTypeToDelete = false;
		} else {
			ServiceTypeDAO serviceTypeDAOInstance = ServiceTypeDAO
					.getInstance();

			serviceTypeDAOInstance.delete(typeJob);
			existsServiceTypeToDelete = true;
		}
		return existsServiceTypeToDelete;
	}

	// General class constructor
	private ServiceTypeController() {
	}

	// Return the current instance or instantiate a new one if 'instance' is
	// null
	public static ServiceTypeController getInstance() {
		if (instance == null) {
			instance = new ServiceTypeController();
		} else {
			// Nothing to do
		}

		return instance;
	}

	/**
	 * Return a ResultSet interface object with the service types registered on
	 * the system
	 * 
	 * @param service
	 *            - Never used ahead, Check need.
	 * @return showRegistredServiceTypes - display Registered Types Of Service
	 *         Result
	 */
	public ResultSet showRegistredServiceTypes(ServiceType service)
			throws SQLException {
		ServiceTypeDAO serviceTypeDAOInstance = ServiceTypeDAO.getInstance();

		ResultSet displayRegisteredTypesOfServiceResult = serviceTypeDAOInstance
				.displayRegisteredTypesOfService(service);

		return displayRegisteredTypesOfServiceResult;
	}

	/**
	 * Search for an specific service type name
	 * 
	 * @param serviceTypeToSearch
	 *            - Service type to search for
	 */
	public static ResultSet searchByName(ServiceType service)
			throws SQLException {
		ServiceTypeDAO serviceTypeDAOInstance = ServiceTypeDAO.getInstance();

		ResultSet searchByNameResult = serviceTypeDAOInstance
				.searchByName(service);

		return searchByNameResult;
	}

}
