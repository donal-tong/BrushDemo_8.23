package imageloader.shiming.com.myapplication.views.doodleview;


import imageloader.shiming.com.myapplication.listeners.ISelectionModeChangedListener;
import imageloader.shiming.com.myapplication.manager.commandmanager.ICommandsManager;
import imageloader.shiming.com.myapplication.manager.modelmager.IModelManager;
import imageloader.shiming.com.myapplication.manager.virsualmanager.IVisualManager;
import imageloader.shiming.com.myapplication.shaperecognize.IShapeRecognizeManager;
import imageloader.shiming.com.myapplication.views.doodleview.opereation.DoodleOperation;

/**
 * Created by $ zhoudeheng on 2015/12/8.
 * Email zhoudeheng@qccr.com
 * 定义Model层，visual层跟DoodleView交互的接口
 */
public interface IInternalDoodle {
    /**
     * 向Doodle插入一个操作
     *
     * @param operation
     */
    void insertOperation(DoodleOperation operation);

    /**
     * 获得当前的Stroke类型
     *
     * @return
     */
    int getStrokeType();

    /**
     * 获得DoodleView中的FrameCache
     *
     * @return
     */
    FrameCache getFrameCache();

    /**
     * 获得临时缓存。分段画笔，会用到此缓存
     *
     * @return
     */
    FrameCache getTempFrameCache();

    IModelManager getModelManager();

    IVisualManager getVisualManager();

    ICommandsManager getCommandsManager();

    /**
     * 获得当前的输入模式
     *
     * @return
     */
    DoodleEnum.InputMode getInputMode();

    DoodleEnum.SelectionMode getSelectionMode();

    void setSelectionMode(DoodleEnum.SelectionMode selectionMode);

    /***
     * 返回整个doodleView
     *
     * @return
     */
    DoodleView getDoodleView();

    boolean isShapeRecognition();

    // public Context getContext();

    IShapeRecognizeManager getShapeRecognizeManager();

    void addSelectionModeChangedListener(
            ISelectionModeChangedListener listener);

    void removeSelectionModeChangedListener(
            ISelectionModeChangedListener listener);
}
