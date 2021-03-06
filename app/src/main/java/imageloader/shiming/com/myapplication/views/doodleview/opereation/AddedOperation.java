package imageloader.shiming.com.myapplication.views.doodleview.opereation;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import imageloader.shiming.com.myapplication.manager.commandmanager.AddedCommand;
import imageloader.shiming.com.myapplication.manager.commandmanager.ICommand;
import imageloader.shiming.com.myapplication.manager.modelmager.IModelManager;
import imageloader.shiming.com.myapplication.manager.virsualmanager.IVisualManager;
import imageloader.shiming.com.myapplication.model.InsertableObjectBase;
import imageloader.shiming.com.myapplication.views.doodleview.FrameCache;
import imageloader.shiming.com.myapplication.views.doodleview.drawstrategy.AddElementDrawStrategy;
import imageloader.shiming.com.myapplication.views.doodleview.drawstrategy.DrawStrategy;
import imageloader.shiming.com.myapplication.visual.VisualElementBase;


/**
 * Created by $ zhoudeheng on 2015/12/8.
 * Email zhoudeheng@qccr.com
 * 当插入一个对象的时候，需要对应的操作
 * 对应改变undo redo
 */
public class AddedOperation extends DoodleOperation {
    protected InsertableObjectBase mInsertableObject;
    private VisualElementBase mVisualElement;
    private AddedCommand mDrawCommand;

    public AddedOperation(FrameCache frameCache, IModelManager modelManager,
                          IVisualManager visualManager, InsertableObjectBase insertableObject) {
        super(frameCache, modelManager, visualManager);
        // TODO Auto-generated constructor stub
        mInsertableObject = insertableObject;
        // TODO Auto-generated constructor stub
        VisualElementBase visualElement = mVisualManager
                .getVisualElement(mInsertableObject);
        mVisualElement = visualElement;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        DrawStrategy drawStrategy = new AddElementDrawStrategy(canvas, mFrameCache,
                mVisualElement);
        if (drawStrategy != null)
            drawStrategy.draw();
    }

    @Override
    public Rect computerDirty() {
        // TODO Auto-generated method stub
        if (mVisualElement == null)
            return null;
        Rect rect = null;
        // if (mVisualStroke.isSegmentDraw()) {
        // rect = mVisualStroke.getDirtyRect();
        // } else {
        // RectF rectF = mVisualStroke.getBounds();
        // if (rectF == null)
        // return null;
        // rect = new Rect((int) rectF.left, (int) rectF.top,
        // (int) rectF.right, (int) rectF.bottom);
        // }
        RectF rectF = mVisualElement.getBounds();
        if (rectF == null)
            return null;
        rect = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right,
                (int) rectF.bottom);
        return rect;
    }

    @Override
    public ICommand onCreateCommand() {
        // TODO Auto-generated method stub
        // ICommand command = null;
        // command = new DrawCommand(mInsertableObject, mModelManager);
        // return command;
        // return null;
        mDrawCommand = new AddedCommand(mInsertableObject, mModelManager);
        return mDrawCommand;
    }

}
