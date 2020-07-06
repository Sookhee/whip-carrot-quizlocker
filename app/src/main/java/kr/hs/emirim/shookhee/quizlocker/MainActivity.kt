package kr.hs.emirim.shookhee.quizlocker

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.preference.MultiSelectListPreference
import android.preference.PreferenceFragment
import android.preference.SwitchPreference
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.annotations.Nullable
import kotlinx.android.synthetic.main.activity_main.*
import kr.hs.emirim.shookhee.quizlocker.adapter.RankingAdapter
import kr.hs.emirim.shookhee.quizlocker.model.User
import java.util.*


class MainActivity : AppCompatActivity() {
    val fragment = MyPreferenceFragment()
    private var mDatabase: DatabaseReference? = null
    private var mMessageReference: DatabaseReference? = null

    var recyclerView: RecyclerView? = null
    var mLayoutManager: LinearLayoutManager? = null
    var adapter: RankingAdapter? = null

    var userRanking =
        ArrayList<User>()
    var rankingKey = ArrayList<String>()

    var database = FirebaseDatabase.getInstance()
    var userReference = database.getReference("user")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pref =
            getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = pref.edit()

        val isLogin = pref.getBoolean("isLogin", false)

        if(isLogin == true){
            setContentView(R.layout.activity_main)
            // preferenceContent FrameLayout 영역을 PreferenceFragment 로 교체
            fragmentManager.beginTransaction().replace(R.id.preferenceContent, fragment).commit()

            recyclerView = findViewById<View>(R.id.ranking_recyclerview) as RecyclerView
            adapter = RankingAdapter()
            mLayoutManager = LinearLayoutManager(this)
            mLayoutManager!!.reverseLayout = true
            mLayoutManager!!.stackFromEnd = true
            recyclerView!!.layoutManager = mLayoutManager
            recyclerView!!.adapter = adapter

            userReference.orderByChild("carrotCount").limitToLast(3)
                .addChildEventListener(object : ChildEventListener {
                    override fun onChildAdded(
                        dataSnapshot: DataSnapshot,
                        @Nullable s: String?
                    ) {
                        rankingKey.add(dataSnapshot.key!!)
                        userRanking.add(
                            dataSnapshot.getValue(
                                User::class.java
                            )!!
                        )
                        val user =
                            dataSnapshot.getValue(
                                User::class.java
                            )
                        adapter!!.addItem(user)
                        adapter!!.notifyDataSetChanged()
                    }

                    override fun onChildChanged(
                        dataSnapshot: DataSnapshot,
                        @Nullable s: String?
                    ) {
                        rankingKey.add(dataSnapshot.key!!)
                        userRanking.add(
                            dataSnapshot.getValue(
                                User::class.java
                            )!!
                        )
                        val user =
                            dataSnapshot.getValue(
                                User::class.java
                            )
                        adapter!!.addItem(user)
                        adapter!!.notifyDataSetChanged()
                    }

                    override fun onChildRemoved(dataSnapshot: DataSnapshot) {}
                    override fun onChildMoved(
                        dataSnapshot: DataSnapshot,
                        @Nullable s: String?
                    ) {
                    }

                    override fun onCancelled(databaseError: DatabaseError) {}
                })

            ivSetting.setOnClickListener{
                val nextIntent = Intent(this, SettingActivity::class.java)
                startActivity(nextIntent)
            }

            userProfileCarrotImage.setOnClickListener{
                val nextIntent = Intent(this, CollectionActivity::class.java)
                startActivity(nextIntent)
            }

            showMoreRankingButton.setOnClickListener{
                val nextIntent = Intent(this, RankingActivity::class.java)
                startActivity(nextIntent)
            }

            goChatting.setOnClickListener{
                val nextIntent = Intent(this, ChatRoomActivity::class.java)
                startActivity(nextIntent)
            }

            val database = FirebaseDatabase.getInstance()
            val userReference = database.getReference("user")

            userReference.orderByChild("email").equalTo(pref.getString("userEmail", ""))
                .addChildEventListener(object : ChildEventListener {
                    override fun onChildAdded(
                        dataSnapshot: DataSnapshot,
                        @Nullable s: String?
                    ) {
                        val user =
                            dataSnapshot.getValue(
                                User::class.java
                            )
                        carrotCountTextView.text = "${user!!.carrotCount} 개"
                        userName.text = user.nickname
                        when (user.profileId) {
                            1 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character01)
                            2 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character02)
                            3 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character03)
                            4 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character04)
                            5 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character05)
                            6 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character06)
                            7 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character07)
                            8 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character08)
                            9 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character09)
                            10 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character10)
                            else -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character01)
                        }
                    }

                    override fun onChildChanged(
                        dataSnapshot: DataSnapshot,
                        @Nullable s: String?
                    ) {
                        val user =
                            dataSnapshot.getValue(
                                User::class.java
                            )
                        carrotCountTextView.text = "${user!!.carrotCount} 개"
                        userName.text = user.nickname
                        when (user.profileId) {
                            1 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character01)
                            2 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character02)
                            3 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character03)
                            4 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character04)
                            5 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character05)
                            6 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character06)
                            7 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character07)
                            8 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character08)
                            9 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character09)
                            10 -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character10)
                            else -> userProfileCarrotImage.setImageResource(R.drawable.carrot_character01)
                        }
                    }

                    override fun onChildRemoved(dataSnapshot: DataSnapshot) {}
                    override fun onChildMoved(
                        dataSnapshot: DataSnapshot,
                        @Nullable s: String?
                    ) {
                    }

                    override fun onCancelled(databaseError: DatabaseError) {}
                })
        }

        else{
            finish()
        }
    }

    class MyPreferenceFragment : PreferenceFragment() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            // 환경설정 리소스 파일 적용
            addPreferencesFromResource(R.xml.pref)
            // 퀴즈 종류 요약정보에, 현재 선택된 항목을 보여주는 코드
            val categoryPref = findPreference("category") as MultiSelectListPreference
            categoryPref.summary = categoryPref.values.joinToString(", ")
            // 환경설정 정보값이 변경될때에도 요약정보를 변경하도록 리스너 등록
            categoryPref.setOnPreferenceChangeListener { preference, newValue ->
                // newValue 파라미터가 HashSet 으로 캐스팅이 실패하면 리턴
                val newValueSet = newValue as? HashSet<*>
                        ?: return@setOnPreferenceChangeListener true
                // 선택된 퀴즈종류로 요약정보 보여줌
                categoryPref.summary = newValue.joinToString(", ")
                true
            }
            // 퀴즈 잠금화면 사용 스위치 객체 가져옴
            val useLockScreenPref = findPreference("useLockScreen") as SwitchPreference
            // 클릭되었을때의 이벤트 리스너 코드 작성
            useLockScreenPref.setOnPreferenceClickListener {
                when {
                    // 퀴즈 잠금화면 사용이 체크된 경우 LockScreenService 실행
                    useLockScreenPref.isChecked -> {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            activity.startForegroundService(Intent(activity, LockScreenService::class.java))
                        } else {
                            activity.startService(Intent(activity, LockScreenService::class.java))
                        }
                    }
                    // 퀴즈 잠금화면 사용이 체크 해제된 경우 LockScreenService 중단
                    else -> activity.stopService(Intent(activity, LockScreenService::class.java))
                }
                true
            }
            // 앱이 시작 되었을때 이미 퀴즈잠금화면 사용이 체크되어있으면 서비스 실행
            if (useLockScreenPref.isChecked) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    activity.startForegroundService(Intent(activity, LockScreenService::class.java))
                } else {
                    activity.startService(Intent(activity, LockScreenService::class.java))
                }
            }
        }
    }
}