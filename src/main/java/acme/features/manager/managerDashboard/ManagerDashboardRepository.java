
package acme.features.manager.managerDashboard;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.entities.project.Project;
import acme.entities.sys_config.SystemConfiguration;
import acme.entities.userstory.UserStory;

@Repository
public interface ManagerDashboardRepository extends AbstractRepository {

	@Query("select us from UserStory us where us.manager.id = :managerId")
	Collection<UserStory> findManyUserStoriesByManagerId(int managerId);

	@Query("select p from Project p where p.manager.id = :managerId")
	Collection<Project> findManyProjectsByManagerId(int managerId);

	@Query("select sc from SystemConfiguration sc")
	List<SystemConfiguration> findSystemConfiguration();
}
