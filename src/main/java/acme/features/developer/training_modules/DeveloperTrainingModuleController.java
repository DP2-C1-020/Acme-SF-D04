
package acme.features.developer.training_modules;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.client.controllers.AbstractController;
import acme.entities.training_module.TrainingModule;
import acme.roles.Developer;

@Controller
public class DeveloperTrainingModuleController extends AbstractController<Developer, TrainingModule> {

	@Autowired
	private DeveloperTrainingModuleListService		listService;

	@Autowired
	private DeveloperTrainingModuleShowService		showService;

	@Autowired
	private DeveloperTrainingModuleDeleteService	deleteService;

	@Autowired
	private DeveloperTrainingModuleUpdateService	updateService;

	@Autowired
	private DeveloperTrainingModuleCreateService	createService;

	@Autowired
	private DeveloperTrainingModulePublishService	publishService;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
		super.addBasicCommand("show", this.showService);
		super.addBasicCommand("delete", this.deleteService);
		super.addBasicCommand("update", this.updateService);
		super.addBasicCommand("create", this.createService);

		super.addCustomCommand("publish", "update", this.publishService);
	}

}
