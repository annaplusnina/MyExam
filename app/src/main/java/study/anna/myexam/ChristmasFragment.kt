package study.anna.myexam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

private const val LAST_ROLLED_IMAGE = "image"

class ChristmasFragment : Fragment() {

    lateinit var christmasImageView: ImageView
    lateinit var christmasButton: Button

    private val christmasImageList: List<Int> = listOf(
        R.drawable.new1,
        R.drawable.new2,
        R.drawable.new3,
        R.drawable.new4,
        R.drawable.new5,
        R.drawable.new6,
    )
    var lastRolledImageRes = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_christmas, container, false)

        christmasImageView = view.findViewById(R.id.christmas_image_view)
        christmasButton = view.findViewById(R.id.christmas_button)

        if (savedInstanceState != null)
            christmasImageView.setImageResource(savedInstanceState.getInt(LAST_ROLLED_IMAGE))

        christmasButton.setOnClickListener {
            lastRolledImageRes = christmasImageList.random()
            christmasImageView.setImageResource(lastRolledImageRes)

        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_ROLLED_IMAGE, lastRolledImageRes)
    }


}

