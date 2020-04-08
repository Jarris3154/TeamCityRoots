package com.github.jarris3154.tools.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Jarris
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class VcsRoot1 {
    @XmlAttribute
    private String id;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String vcsName;
    @XmlAttribute
    private String status;
    @XmlAttribute
    private String lastChecked;
    @XmlAttribute
    private String href;
    @XmlElement
    private Properties properties;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getVcsName() {
        return vcsName;
    }

    public void setVcsName(String vcsName) {
        this.vcsName = vcsName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(String lastChecked) {
        this.lastChecked = lastChecked;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "VcsRoot1{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", vcsName='" + vcsName + '\'' +
                ", status='" + status + '\'' +
                ", lastChecked='" + lastChecked + '\'' +
                ", href='" + href + '\'' +
                ", properties=" + properties +
                '}';
    }
}
