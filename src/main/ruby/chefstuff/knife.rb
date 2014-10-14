# See http://docs.getchef.com/config_rb_knife.html for more information on knife configuration options

current_dir = File.dirname(__FILE__)
log_level                :info
log_location             STDOUT
node_name                "ubante"
client_key               "#{current_dir}/ubante.pem"
validation_client_name   "veggie-chef-validator"
validation_key           "#{current_dir}/veggie-chef-validator.pem"
chef_server_url          "https://api.opscode.com/organizations/veggie-chef"
cache_type               'BasicFile'
cache_options( :path => "#{ENV['HOME']}/.chef/checksums" )
cookbook_path            ["#{current_dir}/../cookbooks"]
