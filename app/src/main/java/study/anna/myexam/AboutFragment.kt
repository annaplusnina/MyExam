package study.anna.myexam

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class AboutFragment : Fragment() {

    lateinit var developeRecyclerView: RecyclerView

    lateinit var forLettersButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        val developersNames:List<String> = listOf("Anna", "Santa Claus", "Snowman")


        forLettersButton=view.findViewById(R.id.for_letters_button)
        developeRecyclerView = view.findViewById(R.id.developer_recycler_view)
        developeRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                developeRecyclerView.adapter=DeveloperAdapter(developersNames)

        forLettersButton.setOnClickListener {

            val link=Uri.parse("https://google.com")
                val intent=Intent(Intent.ACTION_VIEW,link)
                    context?.startActivity(intent)
        }

        return view
    }
}