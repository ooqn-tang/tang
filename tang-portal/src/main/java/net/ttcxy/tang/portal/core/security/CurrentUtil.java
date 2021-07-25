package net.ttcxy.tang.portal.core.security;

import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.entity.dto.CurrentAuthor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class CurrentUtil {

   private static final Logger LOG = LoggerFactory.getLogger(CurrentUtil.class);

   private CurrentUtil() {
   }

   /**
    * 获取当前登录的用户名
    */
   public static String name() {
      CurrentAuthor currentAuthor = author();
      return currentAuthor.getUsername();
   }

   /**
    * 获取当前登录的用户名
    */
   public static CurrentAuthor author() {

      final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

      if (authentication == null) {
         throw new ApiException("未登录");
      }

      return (CurrentAuthor) authentication.getPrincipal();
   }

   /**
    * 获取当前登录的用户名
    */
   public static String id() {
      CurrentAuthor currentAuthor = author();
      return currentAuthor.getAuthorId();
   }
}
