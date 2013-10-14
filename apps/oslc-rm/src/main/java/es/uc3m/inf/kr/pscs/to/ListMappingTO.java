package es.uc3m.inf.kr.pscs.to;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "mappings")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mappings", propOrder = {
    "mapping"
})
public class ListMappingTO {


	private List<PSCMappingTO> mapping = new LinkedList<PSCMappingTO>();

	public ListMappingTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public ListMappingTO(List<PSCMappingTO> mapping) {
		super();
		this.mapping = mapping;
	}



	public List<PSCMappingTO> getMapping() {
		return mapping;
	}


	public void setMapping(List<PSCMappingTO> mapping) {
		this.mapping = mapping;
	}


	@Override
	public String toString() {
		return "ListMappingTO [mappings=" + mapping + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mapping == null) ? 0 : mapping.hashCode());
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
		ListMappingTO other = (ListMappingTO) obj;
		if (mapping == null) {
			if (other.mapping != null)
				return false;
		} else if (!mapping.equals(other.mapping))
			return false;
		return true;
	}
	
	
}
