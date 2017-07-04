package net.vikesh.fk.entity.component;

import net.vikesh.fk.entity.GenericItem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikes on 04-07-2017.
 */
@Entity
public class NavNode extends GenericItem {

    @Column
    private String href = "#";

    @Column
    private String text = "";

    @OneToMany
    private List<NavNode> navNodes = new ArrayList<>();

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getKey() {
        return getUuid();
    }

    public List<NavNode> getNavNodes() {
        return navNodes;
    }

    public void setNavNodes(List<NavNode> navNodes) {
        this.navNodes = navNodes;
    }

    public void addNavNode(NavNode navNode) {
        getNavNodes().add(navNode);
    }

    public void remove(NavNode navNode) {
        getNavNodes().remove(navNode);
    }
}
