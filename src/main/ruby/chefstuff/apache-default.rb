package "httpd" do
  action :install
end

service "httpd" do
  action [ :enable, :start ]
end

cookbook_file "/var/www/html/index.html" do
  source "index.html"
  mode "0644"
end

package "httpd" do
  action :install
end

service "httpd" do
  action [ :enable, :start ]
end


# disable the default virtual host
execute "mv /etc/httpd/conf.d/welcome.conf /etc/httpd/conf.d/welcome.conf.disabled" do
  only_if do
    File.exist?("/etc/httpd/conf.d/welcome.conf")
  end
  notifies :restart, "service[httpd]"
end

# iterate over the apache sites
node["apace"]["sites"].each do |site_name, site_data|

# set the docroot
  document_root = "/srv/apache/#{site_name}"

# add a template for apache virtual host config
  template "/etc/httpd/conf.d/#{site_name}.conf" do
    source "custom.erb"
    mode "0644"
    variables(
        :document_root => document_root,
        :port => site_data["port]
  )
  notifies :restart, "service[httpd]"
end


