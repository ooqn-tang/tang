package net.ttcxy.tang.admin.server;

import net.ttcxy.tang.admin.entity.dto.UtsAuthorDto;

/**
 * @author huanglei
 */
public interface UtsAuthorServer {
    UtsAuthorDto loadAuthorInfo(String username);
}
