package com.ai.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.im4java.core.CompositeCmd;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;
import org.im4java.core.IdentifyCmd;
import org.im4java.process.ArrayListOutputConsumer;
import org.im4java.process.Pipe;

/**
 * 
 * @author wangmanco
 *
 */
public class ImageUtil {

	/**
	 * 
	 * 根据尺寸缩放图片
	 * 
	 * @param width
	 *            缩放后的图片宽度
	 * @param height
	 *            缩放后的图片高度
	 * @param srcPath
	 *            源图片路径
	 * @param newPath
	 *            缩放后图片的路径
	 */
	public static void resize(int width, int height, String srcPath,
			String newPath) {
		IMOperation op = new IMOperation();
		op.addImage(srcPath);
		op.resize(width, height);
		op.addImage(newPath);
		ConvertCmd convert = new ConvertCmd();
//		convert.setSearchPath("/usr/local/bin"); //osx
		if (SystemUtil.getSystem().startsWith("Mac")) {
			convert.setSearchPath("/usr/local/bin"); //osx
		}
//		CompositeCmd composite = new CompositeCmd();
//		composite.run(arg0, arg1);
		try {
			convert.run(op);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得图片的宽度和高度 ，[0]:宽度，[1]高度 
	 * 
	 * @param stream
	 *            文件流
	 * @return 图片宽度
	 */
	public static int[] getWidthAndHeight(InputStream stream) {
	    int[] line = new int[]{0,0};
	    try {
	        IMOperation op = new IMOperation();
	       
	        //op.ping().format("%[EXIF:ISOSpeedRatings]\n");
	        op.format("%w#%h"); // 设置获取宽度参数
	    	Pipe pipeIn = new Pipe(stream, null);
	        op.addImage("-");
	        IdentifyCmd identifyCmd = new IdentifyCmd(false);
	        if (SystemUtil.getSystem().startsWith("Mac")) {
	        	identifyCmd.setSearchPath("/usr/local/bin");
			}
	        identifyCmd.setInputProvider(pipeIn);
	        ArrayListOutputConsumer output = new ArrayListOutputConsumer();
	        identifyCmd.setOutputConsumer(output);
	        identifyCmd.run(op);
	        ArrayList<String> cmdOutput = output.getOutput();
	        assert cmdOutput.size() == 1;
	        
	        String[] ary = cmdOutput.get(0).split("#");
	        if(ary == null || ary.length<2){
	        	System.out.println("图片的长度读取失败!");
	        	return line;
	        }else{
	        	line[0] = Integer.parseInt(ary[0]);
		        line[1] = Integer.parseInt(ary[1]);
	        }
	        	
	        
	    } catch (Exception e) {
	        System.out.println("运行指令出错!");
	        e.printStackTrace();
	        line = new int[]{-1,-1};
	    }
	    return line;
	}
	public static void imgWatermark(String path,String srcImageName,String destImageName) throws Exception{
		InputStream stream = new FileInputStream(path+"/"+srcImageName);
		int[] wh = getWidthAndHeight(stream);
		IMOperation op = new IMOperation();
        op.gravity("center");
//        op.dissolve(dissolve);
        if (wh[0]>900) {
        	op.addImage(path+"/watermark.png");
		}else if (wh[0]<=250) {
			op.addImage(path+"/watermark_small.png");
		}else {
			op.addImage(path+"/watermark_middle.png");
		}
        
//        op.addImage("/Users/wangmanco/Documents/tmp/watermark_middle.png");
        op.addImage(path+"/"+srcImageName);
        op.addImage(path+"/"+destImageName);
        CompositeCmd cmd = new CompositeCmd();
        if (SystemUtil.getSystem().startsWith("Mac")) {
        	cmd.setSearchPath("/usr/local/bin");
		}
        cmd.run(op);

	}
	public static void main(String[] args) {
//		resize(100, 100, "/Users/wangmanco/Documents/tmp/1.jpg", "/Users/wangmanco/Documents/tmp/2.jpg");
		try {
//			imgWatermark();
//			resize(300,300,"/Users/wangmanco/Documents/tmp/personWithIdCard.jpg","/Users/wangmanco/Documents/tmp/3.jpg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

