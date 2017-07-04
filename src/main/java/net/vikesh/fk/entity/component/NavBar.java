package net.vikesh.fk.entity.component;

import net.vikesh.fk.entity.GenericItem;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikes on 04-07-2017.
 */
@Entity
public class NavBar extends GenericItem {

    @OneToMany
    private List<NavNode> navNodes = new ArrayList<>();

    public List<NavNode> getNavNodes() {
        return navNodes;
    }

    public void setNavNodes(List<NavNode> navNodes) {
        this.navNodes = navNodes;
    }
}
