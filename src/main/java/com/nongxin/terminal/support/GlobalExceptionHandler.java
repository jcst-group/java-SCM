package com.nongxin.terminal.support;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import com.nongxin.terminal.exception.ValidateDataException;
import com.nongxin.terminal.vo.Message;
import com.nongxin.terminal.vo.Result;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.io.FileNotFoundException;
import java.net.BindException;
import java.util.List;
import java.util.Map;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 * @author tomsun28
 * @date 22:40 2018/4/16
 */
@RestControllerAdvice
@Order(-1)
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * description 拦截操作数据库异常
     *
     * @param e 1
     * @return com.usthe.bootshiro.domain.vo.Message
     */
    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result<?> sqlException(DataAccessException e) {
        LOGGER.error("数据操作异常:",e);
        final Throwable cause = e.getCause();
        // 之后判断cause类型进一步记录日志处理
        if (cause instanceof MySQLIntegrityConstraintViolationException ) {
            return Result.error("有关联数据，无法删除！！");
            //return Result.error( "数据冲突操作失败"+cause.getMessage());
        }
        return Result.error( "服务器开小差"+cause.getMessage());
    }

    /**
     * description 拦截未知的运行时异常
     *
     * @param e 1
     * @return com.usthe.bootshiro.domain.vo.Message
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    public Message notFoundException(RuntimeException e) {
        LOGGER.error("运行时异常:",e);
        return new Message().error(1111,"服务器开小差");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handleBindException(MethodArgumentNotValidException ex) {

        // ex.getFieldError():随机返回一个对象属性的异常信息。如果要一次性返回所有对象属性异常信息，则调用ex.getAllErrors()
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder builder = new StringBuilder();
        for (FieldError error : fieldErrors) {
            builder.append(error.getDefaultMessage() + "\n");
        }
        return Result.error(builder.toString());
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public Result<?> handleBindException(MaxUploadSizeExceededException ex) {

        // ex.getFieldError():随机返回一个对象属性的异常信息。如果要一次性返回所有对象属性异常信息，则调用ex.getAllErrors()
        Long maxUploadSize = ex.getMaxUploadSize();
        StringBuilder builder = new StringBuilder();
        builder.append("上传文件大小不能超过")
                .append(maxUploadSize/1024/1024)
                .append("M");

        return Result.error(builder.toString());
    }

    @ExceptionHandler(ValidateDataException.class)
    public Result<?> handleValidatorException(ValidateDataException ex) {
        Result<Map> result = new Result<>();
        Map<String, StringBuffer> map = ex.getMap();
        result.setResult(map);
        result.setSuccess(false);
        return result;
    }

    @ExceptionHandler(AuthenticationException.class)
    public Result<?> handleAuthenticationException(AuthenticationException ex) {
        Result<Map> result = new Result<>();
        LOGGER.info("handleAuthenticationException:",ex.getMessage());
        result.setMessage("登陆失效，请重新登陆");
        result.setCode(500);
        result.setSuccess(false);
        return result;
    }

    @ExceptionHandler(BaseException.class)
    public Result<?> handleBaseExceptionException(BaseException ex) {
        Result<Map> result = new Result<>();
        result.setMessage(ex.getMessage());
        result.setCode(500);
        result.setSuccess(false);
        return result;
    }

    @ExceptionHandler(FileNotFoundException.class)
    public Result<?> handleFileNotFoundException(FileNotFoundException ex) {
        Result<Map> result = new Result<>();
        result.setMessage("文件不存在!!");
        result.setCode(500);
        result.setSuccess(false);
        return result;
    }

}
