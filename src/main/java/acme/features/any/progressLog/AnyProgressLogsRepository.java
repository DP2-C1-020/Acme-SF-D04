
package acme.features.any.progressLog;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;
import acme.entities.contracts.Contract;
import acme.entities.progress_logs.ProgressLog;

@Repository
public interface AnyProgressLogsRepository extends AbstractRepository {

	@Query("select pl from ProgressLog pl where pl.contract.id = :id")
	Collection<ProgressLog> findProgressLogsByContractId(int id);

	@Query("select c from Contract c where c.id = :id")
	Contract findContractById(int id);

	@Query("select pl from ProgressLog pl where pl.id = :id")
	ProgressLog findProgressLogsById(int id);

}
