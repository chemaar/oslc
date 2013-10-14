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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import es.uc3m.inf.kr.common.exceptions.DocumentBuilderException;

/**
 * This is a helper class for building Documents from different sources.
 */
public class DocumentBuilderHelper{
    
    private static final Logger logger = Logger.getLogger(DocumentBuilderHelper.class); 
    
	public static Reader getStringReader(String article){
		return new StringReader(article);
	}
	
	public static InputSource getInputSourceFromString(String article){
		Reader reader = getStringReader(article);
		return new InputSource(reader);
	}
	
	public static InputSource getInputSourceFromReader(Reader article){       
		return new InputSource(article);
	}

	public static DocumentBuilder createDocumentBuilder() throws DocumentBuilderException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		try {
			return factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new DocumentBuilderException(e);
		}
	}
	
	public static Document getDocumentFromString(String input) throws DocumentBuilderException {
		try {
			return createDocumentBuilder().parse(getInputSourceFromString(input));
		} catch (SAXException e) {
			throw new DocumentBuilderException(e);
		} catch (IOException e) {
			throw new DocumentBuilderException(e);
		} catch (DocumentBuilderException e) {
			throw new DocumentBuilderException(e);
		}
	}
	
	public static Document getDocumentFromReader(Reader input) throws DocumentBuilderException {
		try {
			return createDocumentBuilder().parse(getInputSourceFromReader(input));
		} catch (SAXException e) {
			throw new DocumentBuilderException(e);
		} catch (IOException e) {
			throw new DocumentBuilderException(e);
		}
	}
	
	public static Document getDocumentFromInputStream(InputStream input) throws DocumentBuilderException {
		try {
			return createDocumentBuilder().parse(input);
		} catch (SAXException e) {
			throw new DocumentBuilderException(e);
		} catch (IOException e) {
			throw new DocumentBuilderException(e);
		}
	}
	
	public static Document getEmptyDocument() throws DocumentBuilderException {
		return createDocumentBuilder().newDocument();
	}

    public static Document getDocumentFromFile(File file) throws DocumentBuilderException, FileNotFoundException {
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            return getDocumentFromInputStream(is);            
        } finally {
            try {
                if (is != null) { is.close(); }
            } catch (IOException e) {
                logger.error("Failed to close file, resuming work", e);
            }
        }
    }
    
}

