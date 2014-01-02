package es.uc3m.inf.kr.common.to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ontologyDataTO")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ontologyDataTO", propOrder = {
    "uri",
    "format",
    "content",
    "label",
    "comment"
})
public class OntologyDataTO {

        private String uri;
        private String format;
        private String content;
        private String label;
        private String comment;
        public String getUri() {
                return uri;
        }
        public void setUri(String uri) {
                this.uri = uri;
        }
        public String getFormat() {
                return format;
        }
        public void setFormat(String format) {
                this.format = format;
        }
        public String getContent() {
                return content;
        }
        public void setContent(String content) {
                this.content = content;
        }
        public OntologyDataTO(String uri, String format, String content) {
                super();
                this.uri = uri;
                this.format = format;
                this.content = content;
        }
        public OntologyDataTO(String uri) {
                super();
                this.uri = uri;
        }
        public OntologyDataTO(String uri, String format) {
                super();
                this.uri = uri;
                this.format = format;
        }
        public OntologyDataTO() {
                super();
        }
        public String getLabel() {
                return label;
        }
        public void setLabel(String label) {
                this.label = label;
        }
        public String getComment() {
                return comment;
        }
        public void setComment(String comment) {
                this.comment = comment;
        }
        
}

