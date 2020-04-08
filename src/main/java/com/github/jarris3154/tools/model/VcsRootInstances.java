package com.github.jarris3154.tools.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Jarris
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class VcsRootInstances {
    @XmlAttribute
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
