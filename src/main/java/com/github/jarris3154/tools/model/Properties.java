package com.github.jarris3154.tools.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author Jarris
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Properties {
    @XmlAttribute
    private String count;
    @XmlElement(name = "property")
    private List<Property> properties;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "count='" + count + '\'' +
                ", properties=" + properties +
                '}';
    }
}
