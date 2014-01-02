package es.uc3m.inf.kr.oslcrm.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.lyo.oslc4j.core.model.AbstractResource;

import es.uc3m.inf.kr.oslcrm.to.Person;
import es.uc3m.inf.kr.oslcrm.to.RequirementTO;

public class DummyRequirementDAOImpl implements RequirementDAO{
	List<RequirementTO> requirements;
	public DummyRequirementDAOImpl(){
		this.requirements = new LinkedList<RequirementTO>();
		this.requirements.add(createRequirementTO());
	}

	public List<RequirementTO> getRequirements() {

		return requirements;
	}

	public RequirementTO getRequirement(String requirementId) {
		RequirementTO target = null;
		boolean found = false;
		int i = 0;
		while(!found && i<this.requirements.size()){
			if (this.requirements.get(i).getIdentifier().equals(requirementId)){
				found = true;
				target = this.requirements.get(i);
			}
		}
		return target;
	}

	private RequirementTO createRequirementTO(){
		RequirementTO requirement = new RequirementTO();
		requirement.setIdentifier("1");
		requirement.setTitle("Car Braking System");
		requirement.setDefinition("Whenever the pedal of the brake is pressed, the car will decelerate immediately");
		requirement.setCreated(Calendar.getInstance().getTime());
		List<AbstractResource> creator = new LinkedList<AbstractResource>();
		Person creator1 = new Person();
		creator1.setName("Jose María Alvarez");
		creator1.setMbox("jose.alvarez@kr.inf.uc3m.es");
		try {
			creator1.setUri(new URI("http://www.josemalvarez.es"));
		} catch (URISyntaxException e) {
			
		}
		creator.add(creator1);
		requirement.setCreator(creator);
		return requirement;
	}

}
