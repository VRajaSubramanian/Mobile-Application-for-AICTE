package com.example.webview.ui.gallery;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //noinspection unused
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final WebView educationWebView = binding.idWebViewEducation;
        final ProgressBar loadingPB = binding.idPBLoading;
        educationWebView.loadUrl("https://www.aicte-india.org/education/overview");
        educationWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                loadingPB.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                loadingPB.setVisibility(View.GONE);
            }
        });
        educationWebView.setOnKeyListener((view, i, keyEvent) -> {
            if (keyEvent.getAction()==KeyEvent.ACTION_DOWN)
            {
                switch (i)
                {
                    case KeyEvent.KEYCODE_BACK:
                        if (educationWebView.canGoBack())
                        {
                            educationWebView.goBack();
                        }
                }
            }
            return false;
        });



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}