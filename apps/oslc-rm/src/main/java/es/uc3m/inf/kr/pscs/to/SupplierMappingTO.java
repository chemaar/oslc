package es.uc3m.inf.kr.pscs.to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "supplierMappingTO")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "supplierMappingTO", propOrder = {
    "from",
    "to",
    "confidence"
})
public class SupplierMappingTO {

	private SupplierTO from;
	private SupplierTO to;
	private double confidence = -1.0;
	public SupplierTO getFrom() {
		return from;
	}
	public void setFrom(SupplierTO from) {
		this.from = from;
	}
	public SupplierTO getTo() {
		if(to == null){
			this.to = new SupplierTO();
		}
		return to;
	}
	public void setTo(SupplierTO to) {
		this.to = to;
	}
	public double getConfidence() {
		return confidence;
	}
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}
	public SupplierMappingTO(SupplierTO from, SupplierTO to, double confidence) {
		super();
		this.from = from;
		this.to = to;
		this.confidence = confidence;
	}
	public SupplierMappingTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SupplierMappingTO [from=" + from + ", to=" + to + ", confidence="
				+ confidence + "]";
	}
	
}
