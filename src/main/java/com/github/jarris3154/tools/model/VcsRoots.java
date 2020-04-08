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
public class VcsRoots {
    @XmlAttribute
    private String count;
    @XmlAttribute
    private String href;

    @XmlElement(name = "vcs-root")
    private List<VcsRoot> vcsRoots;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<VcsRoot> getVcsRoots() {
        return vcsRoots;
    }

    public void setVcsRoots(List<VcsRoot> vcsRoots) {
        this.vcsRoots = vcsRoots;
    }

    @Override
    public String toString() {
        return "VcsRoots{" +
                "count='" + count + '\'' +
                ", vcsRoots=" + vcsRoots +
                '}';
    }
}
