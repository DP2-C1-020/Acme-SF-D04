
package acme.features.authenticated.client;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.data.accounts.UserAccount;
import acme.client.repositories.AbstractRepository;
import acme.roles.Client;

@Repository
public interface AuthenticatedClientRepository extends AbstractRepository {

	@Query("select uA from UserAccount uA where uA.id = :id")
	UserAccount findUserAccountById(int id);

	@Query("select c from Client c where c.userAccount.id = :id")
	Client findClientByUserAccountId(int id);

	@Query("select c from Client c where c.identification = :identification")
	Client findClientByIdentification(String identification);

}
