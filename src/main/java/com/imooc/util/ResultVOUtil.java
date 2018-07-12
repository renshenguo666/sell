package com.imooc.util;

import com.imooc.VO.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return  resultVO;
    }
    public static ResultVO success(){
        return success(null);
    }
    public static ResultVO error(){
        ResultVO<Object> resultVO = new ResultVO<>();
        return  resultVO;
    }


}
