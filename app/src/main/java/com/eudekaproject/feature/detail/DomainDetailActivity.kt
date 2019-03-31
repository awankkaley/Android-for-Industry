package com.eudekaproject.feature.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.eudekaproject.R
import com.eudekaproject.utils.formatDate
import com.eudekaproject.utils.formatList
import kotlinx.android.synthetic.main.activity_domain_detail.*

class DomainDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_domain_detail)
        supportActionBar?.title = resources.getString(R.string.domain_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tv_a_detail.formatList(intent.getStringExtra("a"))
        tv_active_date_detail.text = intent.getStringExtra("isdead")
        tv_country_detail.text = intent.getStringExtra("country")
        tv_create_date_detail.formatDate(intent.getStringExtra("createdate"))
        tv_expiry_date_detail.formatDate(intent.getStringExtra("expirydate"))
        tv_mx_detail.text = intent.getStringExtra("mx")
        tv_name_domain_detail.text = intent.getStringExtra("domain")
        tv_ns_detail.formatList(intent.getStringExtra("ns"))
        tv_resolvable_detail.text = intent.getStringExtra("resolvable")
        tv_txt_detail.text = intent.getStringExtra("txt")
        tv_update_date_detail.formatDate(intent.getStringExtra("updatedate"))
        tv_apps_detail.text = intent.getStringExtra("apps")
        tv_cname_detail.text = intent.getStringExtra("cname")
        tv_parser_detail.text = intent.getStringExtra("parser")
        tv_parsererror_detail.text = intent.getStringExtra("parsererror")
        tv_robotstxt_detail.text = intent.getStringExtra("robotstxt")
        tv_url_detail.text = intent.getStringExtra("url")
        tv_suffix_detail.text = intent.getStringExtra("suffix")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
