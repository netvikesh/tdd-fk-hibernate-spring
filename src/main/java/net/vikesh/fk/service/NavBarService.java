package net.vikesh.fk.service;

import net.vikesh.fk.entity.component.NavBar;
import net.vikesh.fk.entity.component.NavNode;
import net.vikesh.fk.repository.NavBarRepository;
import net.vikesh.fk.repository.NavNodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by vikes on 04-07-2017.
 */
@Service
public class NavBarService {

    @Resource
    private NavNodeRepository navNodeRepository;

    @Resource
    private NavBarRepository navBarRepository;

    public NavBar saveNavBar(NavBar navBar) {
        List<NavNode> navNodes = navBar.getNavNodes();
        navNodes.forEach(this::saveNavNode);
        navNodeRepository.save(navNodes);
        return navBarRepository.save(navBar);
    }

    private void saveNavNode(NavNode navNode) {
        if (!CollectionUtils.isEmpty(navNode.getNavNodes())) {
            navNode.getNavNodes().forEach(this::saveNavNode);
        } else {
            navNodeRepository.save(navNode);
        }
    }

}
