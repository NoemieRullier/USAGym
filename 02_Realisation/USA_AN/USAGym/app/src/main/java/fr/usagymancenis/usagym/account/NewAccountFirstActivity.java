package fr.usagymancenis.usagym.account;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import fr.usagymancenis.usagym.R;

public class NewAccountFirstActivity extends Activity {

    private final static String TAG = NewAccountFirstActivity.class.getSimpleName();

    // Result code after galery call
    private final static int RESULT_LOAD_IMG = 1;

    private Button mTakePicture, mLoadPicture, mNext;

    private ImageView mAccountPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account_first);

        mAccountPicture = (ImageView) findViewById(R.id.account_picture);

        mTakePicture = (Button) findViewById(R.id.account_take_picture);
        mTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the appareil photo
                // TODO A activer que si il y a un appareil photo sinon grisé le bouton
            }
        });

        mLoadPicture = (Button) findViewById(R.id.account_load_picture);
        mLoadPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Image applications like Gallery, Google Photos
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
            }
        });

        mNext = (Button) findViewById(R.id.account_next);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && null != data) {

                // Get the Image from data
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String imgDecodableString = cursor.getString(columnIndex);
                cursor.close();

                // Set the Image in ImageView after decoding the String
                mAccountPicture.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
            }
        } catch (Exception e) {
            Log.w(TAG, e.getMessage());
            Toast.makeText(this, getString(R.string.erreur), Toast.LENGTH_LONG).show();
        }
    }

}
