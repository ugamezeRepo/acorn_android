package com.example.step08galleryexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class GalleryAdapter(
    val context: Context, val layoutRes: Int, val list: MutableList<GalleryDto>
) : BaseAdapter() {
    val inflater = LayoutInflater.from(context)

    override fun getCount(): Int {

        // 전체 모델의 개수 리턴
        return list.size
    }

    override fun getItem(position: Int): Any {

        // 인덱스에 해당하는 아이템 리턴
        return list[position]
    }

    override fun getItemId(position: Int): Long {

        // 인덱스에 해당하는 아이템의 pk를 Long type으로 리턴
        return list[position].num.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // 상수 값을 변수에 임시적으로 담는다.
//        var convertView2 = convertView
//        if (convertView2 == null) {
//            convertView2 = inflater.inflate(layoutRes, parent, false)
//        }
        var convertView2 = convertView ?: inflater.inflate(layoutRes, parent, false)

        // position에 해당되는 GalleryDto를 얻어와서
        val dto = list[position]

        // UI의 참조값도 얻어와서
//         !! => null일 가능성이 없으니 걱정말고 사용해!
//        val imageView: ImageView = convertView2!!.findViewById(R.id.imageView)
        val imageView: ImageView = convertView2.findViewById(R.id.imageView)
        val textWriter: TextView = convertView2.findViewById(R.id.writer)
        val textCaption: TextView = convertView2.findViewById(R.id.caption)
        val textRegdate: TextView = convertView2.findViewById(R.id.regdate)

        // UI에 데이터 출력해서
        textWriter.text = dto.writer // textWriter.setText(dto.getWriter())
        textCaption.text = dto.caption
        textRegdate.text = dto.regdate

        // ImageView에는 Glide를 이용해서 이미지 출력
        Glide.with(context)// 해당 context(액티비티)의 생명주기 내에서 동작
            .load(dto.imagePath) // 로딩할 이미지 경로. "http://192.168.0.???(148):9000/boot09/upload/images/xxx"
            .centerCrop() // 이미지 출력 전략
            .placeholder(R.drawable.ic_launcher_background) // 로딩 완료 전에 출력할 이미지
            .into(imageView) // 로딩이 완료되면 어디에 출력할 것인 지

        // 리턴
        return convertView2
    }
}