package it.nplace.downloadspathprovider;

import android.os.Environment;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.embedding.engine.plugins.FlutterPlugin;

/**
 * DownloadsPathProviderPlugin
 */
public class DownloadsPathProviderPlugin implements FlutterPlugin, MethodCallHandler {

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        pluginRegisterWith(binding.getBinaryMessenger());
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        // TODO: your plugin is no longer attached to a Flutter experience.
    }

    /**
     * Plugin registration.
     */
    public static void registerWith(Registrar registrar) {
        pluginRegisterWith(registrar.messenger());
    }

    private static void pluginRegisterWith(BinaryMessenger messanger) {
        final MethodChannel channel = new MethodChannel(messanger, "downloads_path_provider_28");
        channel.setMethodCallHandler(new DownloadsPathProviderPlugin());
    }


    @Override
    public void onMethodCall(MethodCall call, Result result) {
        if (call.method.equals("getDownloadsDirectory")) {
            result.success(getDownloadsDirectory());
        } else {
            result.notImplemented();
        }
    }

    private String getDownloadsDirectory() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
    }

}
