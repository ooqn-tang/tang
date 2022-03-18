package cn.ttcxy.core.security;

import cn.ttcxy.entity.dto.CurrentAuthor;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
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
      final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      if (authentication.getPrincipal() instanceof UserDetails) {
         return ((CurrentAuthor) authentication.getPrincipal()).getUsername();
      }
      throw new ApiException(ResponseCode.UNAUTHORIZED);
   }

   /**
    * 获取当前登录的用户名
    */
   public static CurrentAuthor author() {
      final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      if (authentication.getPrincipal() instanceof UserDetails) {
         return (CurrentAuthor) authentication.getPrincipal();
      }
      return null;
   }

   /**
    * 获取当前登录的用户名
    */
   public static String id() {
      final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      if (authentication.getPrincipal() instanceof UserDetails) {
         return ((CurrentAuthor) authentication.getPrincipal()).getAuthor().getAuthorId();
      }
      throw new ApiException(ResponseCode.UNAUTHORIZED);
   }
}
