package net.ttcxy.tang.admin.server;

import net.ttcxy.tang.model.UtsResource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huanglei
 */
public interface UtsResourceService {
    List<UtsResource> listAll();
}
