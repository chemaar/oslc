package es.uc3m.inf.kr.common.to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "modelTO")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modelTO", propOrder = {
    "content"
})
public class ModelTO {

        private String content;

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }

        public ModelTO(String content) {
                super();
                this.content = content;
        }

        public ModelTO() {
                super();
                // TODO Auto-generated constructor stub
        }
        
}