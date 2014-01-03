package es.uc3m.inf.kr.common.to;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRepresentation;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.Representation;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

import es.uc3m.inf.kr.oslcrm.Constants;

@OslcNamespace(Constants.KNOWLEDGE_MANAGEMENT_DOMAIN)
@OslcName("KnowledgeElement") 
@OslcResourceShape(title = "Knowledge management Resource Shape", describes = Constants.KM_TYPE_VOCABULARY_ELEMENT)
public class ResourceTO extends AbstractResource{

        private String label = "FIXME";
        private String description = "";
        private String type = "";
        

        @OslcDescription("A default Linked Data Label")
	    @OslcName("label")
        @OslcOccurs(Occurs.ZeroOrOne)
	    @OslcPropertyDefinition(OslcConstants.RDFS_NAMESPACE + "label")
	    @OslcRepresentation(Representation.Inline)
	    @OslcValueType(ValueType.String)
	    @OslcTitle("label")
        public String getLabel() {
                return label;
        }
        public void setLabel(String label) {
                this.label = label;
        }
    	@OslcDescription("The Element description.")
    	@OslcOccurs(Occurs.ZeroOrOne)
    	@OslcPropertyDefinition(Constants.DCTERMS_DESCRIPTION)
    	@OslcRepresentation(Representation.Inline)
    	@OslcValueType(ValueType.String)
    	@OslcRange("xsd:string")
    	@OslcTitle("description")
        public String getDescription() {
                return description;
        }
        public void setDescription(String description) {
                this.description = description;
        }
//        @OslcDescription("The Element type.")
//    	@OslcOccurs(Occurs.ZeroOrOne)
//    	@OslcPropertyDefinition(Constants.DCTERMS_SUBJECT)
//    	@OslcRepresentation(Representation.Inline)
//    	@OslcValueType(ValueType.String)
//        @OslcRange("xsd:string")
//    	@OslcTitle("type")
        public String getType() {
                return type;
        }
        public void setType(String type) {
                this.type = type;
        }
        public ResourceTO() {
                super();
                // TODO Auto-generated constructor stub
        }
        
        public void setUri(String uri){
        	try {
				this.setAbout(new URI(uri));
			} catch (URISyntaxException e) {
				throw new RuntimeException(e);
			}
        }
        
        public String getUri(){
        	return this.getAbout().toASCIIString();
        }
        public ResourceTO(String uri) {
        	setUri(uri);
		}
		@Override
        public String toString() {
                return "ResourceTO [uri=" + this.getAbout().toASCIIString() + ", label=" + label + ", description="
                                + description + ", type=" + type + "]";
        }
        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result
                                + ((description == null) ? 0 : description.hashCode());
                result = prime * result + ((label == null) ? 0 : label.hashCode());
                result = prime * result + ((type == null) ? 0 : type.hashCode());
                result = prime * result + ((this.getAbout().toASCIIString() == null) ? 0 : this.getAbout().toASCIIString().hashCode());
                return result;
        }
        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                ResourceTO other = (ResourceTO) obj;
                if (description == null) {
                        if (other.description != null)
                                return false;
                } else if (!description.equals(other.description))
                        return false;
                if (label == null) {
                        if (other.label != null)
                                return false;
                } else if (!label.equals(other.label))
                        return false;
                if (type == null) {
                        if (other.type != null)
                                return false;
                } else if (!type.equals(other.type))
                        return false;
                if (this.getAbout().toASCIIString() == null) {
                        if (other.getAbout().toASCIIString() != null)
                                return false;
                } else if (!this.getAbout().toASCIIString().equals(other.getAbout().toASCIIString()))
                        return false;
                return true;
        }
        
}
