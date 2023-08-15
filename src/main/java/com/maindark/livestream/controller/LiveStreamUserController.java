package com.maindark.livestream.controller;

import com.maindark.livestream.domain.LiveStreamUser;
import com.maindark.livestream.result.CodeMsg;
import com.maindark.livestream.result.Result;
import com.maindark.livestream.service.LiveStreamUserService;
import com.maindark.livestream.vo.LoginVo;
import com.maindark.livestream.vo.ResetPasswordVo;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/users/")
public class LiveStreamUserController {

    @Resource
    LiveStreamUserService liveStreamUserService;
   @PatchMapping ("/{token}")
    public Result<Boolean> updatePasswordById(LiveStreamUser liveStreamUser, @Valid @RequestBody ResetPasswordVo resetPasswordVo, @PathVariable("token") String token){
        Long userId = liveStreamUser.getId();
        String password = resetPasswordVo.getPassword();
       log.info("id:"+userId +" password:" + password +" token:" + token);
       Boolean res = liveStreamUserService.updatePassword(token,userId,password);
       return Result.success(true);
    }
}
