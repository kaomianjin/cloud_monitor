package com.jinkun.cloud_monitor.intercept;

import com.jinkun.cloud_monitor.constant.ResponseEnum;
import com.jinkun.cloud_monitor.domain.vo.ResultInfo;
import com.jinkun.cloud_monitor.exception.ParameterException;
import com.jinkun.cloud_monitor.exception.ServeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/***
 * @ClassName: ExceptionHandler
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/11/13 11:55
 * @version : V1.0
 */
@RestControllerAdvice
@Slf4j
public class InterceptingExceptionHandler {

    @ExceptionHandler(value = ParameterException.class)
    public ResultInfo<Boolean> parameterException(ParameterException e) {
        return ResultInfo.failedResultInfo(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = ServeException.class)
    public ResultInfo<Boolean> serveException(ServeException e) {
        return ResultInfo.failedResultInfo(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResultInfo httpMessageNotReadableException(HttpServletRequest req, HttpMessageNotReadableException e) {
        log.error("全局异常拦截器 请求参数格式不正确  {} 请求地址 {}  /  异常信息  {}", e, req.getRequestURL(), e.getMessage());
        return ResultInfo.failedResultInfo(ResponseEnum.PARAMETER_ERROR.getCode(), ResponseEnum.PARAMETER_ERROR.getMsg());
    }

    @ExceptionHandler(value = SQLException.class)
    public ResultInfo sqlErrorHandler(HttpServletRequest req, SQLException e) {
        log.error("全局异常拦截器 sql语句异常  {} 请求地址 {}  /  异常信息  {}", e, req.getRequestURL(), e.getMessage());
        return ResultInfo.failedResultInfo("系统繁忙,请稍后重试");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultInfo runErrorHandler(HttpServletRequest req, MethodArgumentNotValidException e) {
        log.error("全局异常拦截器 运行异常  {} 请求地址 {}  /  异常信息  {}", e, req.getRequestURL(), e.getMessage());
        return ResultInfo.failedResultInfo(ResponseEnum.PARAMETER_ERROR.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResultInfo runErrorHandler(HttpServletRequest req, MissingServletRequestParameterException e) {
        log.error("全局异常拦截器 运行异常  {} 请求地址 {}  /  异常信息  {}", e, req.getRequestURL(), e.getMessage());
        return ResultInfo.failedResultInfo(ResponseEnum.PARAMETER_ERROR.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResultInfo runErrorHandler(HttpServletRequest req, HttpRequestMethodNotSupportedException e) {
        log.error("全局异常拦截器 运行异常  {} 请求地址 {}  /  异常信息  {}", e, req.getRequestURL(), e.getMessage());
        return ResultInfo.failedResultInfo(ResponseEnum.PARAMETER_ERROR.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public ResultInfo runErrorHandler(HttpServletRequest req, HttpMediaTypeNotSupportedException e) {
        log.error("全局异常拦截器 运行异常  {} 请求地址 {}  /  异常信息  {}", e, req.getRequestURL(), e.getMessage());
        return ResultInfo.failedResultInfo(ResponseEnum.PARAMETER_ERROR.getCode(),e.getMessage());
    }


    @ExceptionHandler(value = ResourceAccessException.class)
    public ResultInfo runErrorHandler(HttpServletRequest req, ResourceAccessException e) {
        log.error("全局异常拦截器 运行异常  {} 请求地址 {}  /  异常信息  {}", e, req.getRequestURL(), e.getMessage());
        return ResultInfo.failedResultInfo(e.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResultInfo runErrorHandler(HttpServletRequest req, RuntimeException e) {
        log.error("全局异常拦截器 运行异常  {} 请求地址 {}  /  异常信息  {}", e, req.getRequestURL(), e.getMessage());
        return ResultInfo.failedResultInfo(e.getMessage());
    }


    @ExceptionHandler(value = Exception.class)
    public ResultInfo<Boolean> exception(Exception e) {
        return ResultInfo.failedResultInfo("服务器内部异常");
    }
}
