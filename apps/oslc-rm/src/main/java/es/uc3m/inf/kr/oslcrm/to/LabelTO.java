package es.uc3m.inf.kr.oslcrm.to;

import java.net.URI;

import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;

import com.hp.hpl.jena.sparql.vocabulary.FOAF;

import es.uc3m.inf.kr.oslcrm.Constants;
import es.uc3m.inf.kr.oslcrm.SKOS;

public class LabelTO {

@OslcNamespace(SKOS.CORE_NAMESPACE)
@OslcResourceShape(title = "Vocabulary Label Resource Shape", describes = "FIXME")
public class Person extends AbstractResource {
	private URI uri = null;
	private String name = null;
	private String mbox = null;

    
	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	@OslcDescription("A FOAF name ")    
	@OslcPropertyDefinition(Constants.FOAF_NAME_PROPERTY) //@OslcPropertyDefinition(FOAF.name.getURI().toString())
    @OslcReadOnly
    @OslcTitle("Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@OslcDescription("A FOAF Email address ")
    @OslcPropertyDefinition(Constants.FOAF_MBOX_PROPERTY)   //@OslcPropertyDefinition(FOAF.mbox.getURI())
    @OslcReadOnly
    @OslcTitle("Email Address")
	public String getMbox() {
		return mbox;
	}

	public void setMbox(String mbox) {
		this.mbox = mbox;
	}
}

}
