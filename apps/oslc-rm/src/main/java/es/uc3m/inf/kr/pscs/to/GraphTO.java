package es.uc3m.inf.kr.pscs.to;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "graph")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "graph", propOrder = {
    "name",
    "label",
    "size",
    "children"
})
public class GraphTO {

	
	String name;
	String label;
	int size;
	
	List<GraphTO> children;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<GraphTO> getChildren() {
		if(this.children==null){
			this.children = new LinkedList<GraphTO>();
		}
		return children;
	}
	public void setChildren(List<GraphTO> children) {
		this.children = children;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@Override
	public String toString() {
		return "GraphTO [name=" + name + ", label=" + label + ", size=" + size
				+ ", children=" + children + "]";
	}
	
	
	
}
