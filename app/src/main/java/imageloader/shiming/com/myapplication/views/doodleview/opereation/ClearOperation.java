package imageloader.shiming.com.myapplication.views.doodleview.opereation;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;

import imageloader.shiming.com.myapplication.manager.commandmanager.ICommand;
import imageloader.shiming.com.myapplication.manager.modelmager.IModelManager;
import imageloader.shiming.com.myapplication.manager.virsualmanager.IVisualManager;
import imageloader.shiming.com.myapplication.views.doodleview.FrameCache;


/**
 * Created by $ zhoudeheng on 2015/12/9.
 * Email zhoudeheng@qccr.com
 * 清空绘图,UI线程跟DrawThread通信的数据类。ClearOperation并不产生Icommand
 */
public class ClearOperation extends DoodleOperation {

    // public ClearOperation(SurfaceHolder surfaceHolder, FrameCache frameCache,
    // List<DrawTool> allDrawTools, CommandsManager commandsManager) {
    // super(surfaceHolder, frameCache, allDrawTools, commandsManager);
    // // TODO Auto-generated constructor stub
    // }
    public ClearOperation(FrameCache frameCache, IModelManager modelManager,
                          IVisualManager visualManager) {
        super(frameCache, modelManager, visualManager);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        mFrameCache.clearBitmap();
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
    }

    @Override
    public ICommand onCreateCommand() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Rect computerDirty() {
        // TODO Auto-generated method stub
        return null;
    }
}

