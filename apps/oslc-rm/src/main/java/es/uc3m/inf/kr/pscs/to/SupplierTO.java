package es.uc3m.inf.kr.pscs.to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "supplierTO")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "supplierTO", propOrder = {
    "key",
    "label",
    "uri"
})
public class SupplierTO {
	String key;
	String label;
	String uri;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}

	public SupplierTO(String key, String label, String uri) {
		super();
		this.key = key;
		this.label = label;
		this.uri = uri;
	}
	public SupplierTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		SupplierTO other = (SupplierTO) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SupplierTO [key=" + key + ", label=" + label + ", uri=" + uri
				+ "]";
	}

	
}
