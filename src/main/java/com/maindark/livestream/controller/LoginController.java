package com.maindark.livestream.controller;

import com.maindark.livestream.result.Result;
import com.maindark.livestream.service.LiveStreamUserService;
import com.maindark.livestream.vo.LoginVo;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Resource
    LiveStreamUserService liveStreamUserService;

    @PostMapping (value = "/do-login")
    public Result<String> doLogin(HttpServletResponse response, @RequestBody @Valid LoginVo loginVo){
        log.info(loginVo.toString());
        String token = liveStreamUserService.login(response,loginVo);
        return Result.success(token);
    }
}
