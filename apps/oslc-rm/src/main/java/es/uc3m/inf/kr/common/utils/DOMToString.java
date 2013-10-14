/**
 * (c) Copyright 2011 WESO, Computer Science Department,
 * Facultad de Ciencias, University of Oviedo, Oviedo, Asturias, Spain, 33007
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package es.uc3m.inf.kr.common.utils;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;

/**
 * This is a helper class for serilizing Documents in XML.
 */
public class DOMToString {
			public static String printXML(Document doc) {
				OutputFormat  outFormat    = null;
				outFormat = new OutputFormat();
				outFormat.setEncoding("UTF-8");
				outFormat.setVersion("1.0");
				outFormat.setIndenting(true);
				outFormat.setIndent(6);
				return  printXML(doc, outFormat);  	 
			}

	    public static String printXML(Document doc,OutputFormat outFormat) {
	        StringWriter  strWriter    = new StringWriter();
	        XMLSerializer serializer   = new XMLSerializer(strWriter,outFormat);
	            try {
	                serializer.serialize(doc);
	                strWriter.close();
	            } catch (IOException e) {
	                return "";
	            }		        
		     return  strWriter.toString();  	 
		}
	    public static String print(Document doc){			
	    	StringWriter writer = new StringWriter();
		    try {
				TransformerFactory.newInstance().newTransformer().transform( new DOMSource(doc),  new StreamResult(writer));
			} catch (Exception e){
			}
			return writer.toString();
	    }
	}

