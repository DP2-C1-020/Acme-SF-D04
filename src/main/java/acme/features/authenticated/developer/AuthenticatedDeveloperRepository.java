
package acme.features.authenticated.developer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.data.accounts.UserAccount;
import acme.client.repositories.AbstractRepository;
import acme.roles.Developer;

@Repository
public interface AuthenticatedDeveloperRepository extends AbstractRepository {

	@Query("select ua from UserAccount ua where ua.id = :userAccountId")
	UserAccount findUserAccountById(int userAccountId);

	@Query("select d from Developer d where d.userAccount.id = :userAccountId")
	Developer findDeveloperByUserAccountId(int userAccountId);

}
