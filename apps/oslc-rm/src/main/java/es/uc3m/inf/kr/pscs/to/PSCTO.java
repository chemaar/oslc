package es.uc3m.inf.kr.pscs.to;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "pscTO")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pscTO", propOrder = {
    "id",
    "prefLabel",
    "uri",
    "type",
    "subject",
    "inScheme",
    "narrowers"
})
public class PSCTO {

	private String id;
	private String prefLabel;
	private String uri;
	private String type;
	private String subject;
	private String inScheme;	
	private List<PSCTO> narrowers;
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public PSCTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PSCTO(String uri) {
		super();
		this.uri = uri;
	}
	public PSCTO(String id, String uri) {
		super();
		this.id = id;
		this.uri = uri;
	}
	public String getPrefLabel() {
		return prefLabel;
	}
	public void setPrefLabel(String prefLabel) {
		this.prefLabel = prefLabel;
	}
	
	@Override
	public String toString() {
		return "PSCTO [id=" + id + ", prefLabel=" + prefLabel + ", uri=" + uri
				+ ", type=" + type + ", subject=" + subject + ", inScheme="
				+ inScheme + ", narrowers=" + narrowers + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((inScheme == null) ? 0 : inScheme.hashCode());
		result = prime * result
				+ ((narrowers == null) ? 0 : narrowers.hashCode());
		result = prime * result
				+ ((prefLabel == null) ? 0 : prefLabel.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
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
		PSCTO other = (PSCTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inScheme == null) {
			if (other.inScheme != null)
				return false;
		} else if (!inScheme.equals(other.inScheme))
			return false;
		if (narrowers == null) {
			if (other.narrowers != null)
				return false;
		} else if (!narrowers.equals(other.narrowers))
			return false;
		if (prefLabel == null) {
			if (other.prefLabel != null)
				return false;
		} else if (!prefLabel.equals(other.prefLabel))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<PSCTO> getNarrowers() {
		if(this.narrowers==null){
			this.narrowers = new LinkedList<PSCTO>();
		}
		return narrowers;
	}
	public void setNarrowers(List<PSCTO> narrowers) {
		this.narrowers = narrowers;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getInScheme() {
		return inScheme;
	}
	public void setInScheme(String inScheme) {
		this.inScheme = inScheme;
	}
	

}
