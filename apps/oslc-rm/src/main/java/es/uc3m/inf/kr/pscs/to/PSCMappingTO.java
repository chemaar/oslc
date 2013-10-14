package es.uc3m.inf.kr.pscs.to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "pscMappingTO")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pscMappingTO", propOrder = {
    "from",
    "to",
    "confidence"
})
public class PSCMappingTO {

	private PSCTO from;
	private PSCTO to;
	private double confidence = -1.0;
	public PSCTO getFrom() {
		return from;
	}
	public void setFrom(PSCTO from) {
		this.from = from;
	}
	public PSCTO getTo() {
		if(to == null){
			this.to = new PSCTO();
		}
		return to;
	}
	public void setTo(PSCTO to) {
		this.to = to;
	}
	public double getConfidence() {
		return confidence;
	}
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}
	public PSCMappingTO(PSCTO from, PSCTO to, double confidence) {
		super();
		this.from = from;
		this.to = to;
		this.confidence = confidence;
	}
	public PSCMappingTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MappingTO [from=" + from + ", to=" + to + ", confidence="
				+ confidence + "]";
	}
	
}
