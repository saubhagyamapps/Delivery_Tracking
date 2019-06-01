package com.deliverytracking;

import java.util.List;

public class Testing {

    /**
     * geocoded_waypoints : [{"place_id":"ChIJy0dDGLicXjkRUA6lZoAd8_0","geocoder_status":"OK","types":["street_address"]},{"place_id":"ChIJN-qzBLWcXjkR1G_fPxwPKkA","geocoder_status":"OK","types":["route"]}]
     * routes : [{"bounds":{"northeast":{"lat":23.0771609,"lng":72.5180714},"southwest":{"lat":23.0742788,"lng":72.5076035}},"copyrights":"Map data ©2019","legs":[{"distance":{"text":"1.4 km","value":"1406"},"duration":{"text":"17 mins","value":"1041"},"end_address":"Vrundavan Party Plot Rd, Sola, Ahmedabad, Gujarat 380060, India","end_location":{"lat":23.0770711,"lng":72.5180714},"start_address":"A-29, Sola, Ahmedabad, Gujarat 380060, India","start_location":{"lat":23.0771609,"lng":72.5080006},"steps":[{"distance":{"text":"87 m","value":"87"},"duration":{"text":"1 min","value":"60"},"end_location":{"lat":23.0764707,"lng":72.5076035},"html_instructions":"Head <b>southwest<\/b> toward <b>Science City Rd<\/b>","polyline":{"points":"ggzkC_vpyLhCnA"},"start_location":{"lat":23.0771609,"lng":72.5080006},"travel_mode":"WALKING"},{"distance":{"text":"0.5 km","value":"523"},"duration":{"text":"6 mins","value":"380"},"end_location":{"lat":23.0742788,"lng":72.5121291},"html_instructions":"Turn <b>left<\/b> onto <b>Science City Rd<\/b><div style=\"font-size:0.9em\">Pass by Bank of Baroda ATM (on the left in 240&nbsp;m)<\/div>","maneuver":"turn-left","polyline":{"points":"}bzkCospyL`CkGHUBIfCwG`AkCzAyD"},"start_location":{"lat":23.0764707,"lng":72.5076035},"travel_mode":"WALKING"},{"distance":{"text":"0.3 km","value":"340"},"duration":{"text":"5 mins","value":"271"},"end_location":{"lat":23.0769413,"lng":72.5137558},"html_instructions":"Turn <b>left<\/b>","maneuver":"turn-left","polyline":{"points":"guykCyoqyLqCuAkB_AsCwAk@We@[o@c@"},"start_location":{"lat":23.0742788,"lng":72.5121291},"travel_mode":"WALKING"},{"distance":{"text":"0.2 km","value":"205"},"duration":{"text":"2 mins","value":"145"},"end_location":{"lat":23.0768267,"lng":72.5157586},"html_instructions":"Turn <b>right<\/b>","maneuver":"turn-right","polyline":{"points":"{ezkC_zqyLDyADwADy@BcD"},"start_location":{"lat":23.0769413,"lng":72.5137558},"travel_mode":"WALKING"},{"distance":{"text":"9 m","value":"9"},"duration":{"text":"1 min","value":"7"},"end_location":{"lat":23.0767541,"lng":72.5157289},"html_instructions":"Turn <b>right<\/b> onto <b>Bhagwat Vidyapith Rd<\/b>","maneuver":"turn-right","polyline":{"points":"eezkCofryLND"},"start_location":{"lat":23.0768267,"lng":72.5157586},"travel_mode":"WALKING"},{"distance":{"text":"0.2 km","value":"242"},"duration":{"text":"3 mins","value":"178"},"end_location":{"lat":23.0770711,"lng":72.5180714},"html_instructions":"Turn <b>left<\/b><div style=\"font-size:0.9em\">Destination will be on the left<\/div>","maneuver":"turn-left","polyline":{"points":"udzkCifryLMiBGeAOcCGk@QsB"},"start_location":{"lat":23.0767541,"lng":72.5157289},"travel_mode":"WALKING"}],"via_waypoint":[]}],"overview_polyline":{"points":"ggzkC_vpyLhCnA`CkGL_@hEcLzAyDqCuA_GwCqAs@o@c@DyAJqCBcDNDUoDWoDQsB"},"summary":"Science City Rd","warnings":["Walking directions are in beta.    Use caution \u2013 This route may be missing sidewalks or pedestrian paths."],"waypoint_order":[]}]
     * status : OK
     */

    private String status;
    private List<GeocodedWaypointsBean> geocoded_waypoints;
    private List<RoutesBean> routes;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<GeocodedWaypointsBean> getGeocoded_waypoints() {
        return geocoded_waypoints;
    }

    public void setGeocoded_waypoints(List<GeocodedWaypointsBean> geocoded_waypoints) {
        this.geocoded_waypoints = geocoded_waypoints;
    }

    public List<RoutesBean> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RoutesBean> routes) {
        this.routes = routes;
    }

    public static class GeocodedWaypointsBean {
        /**
         * place_id : ChIJy0dDGLicXjkRUA6lZoAd8_0
         * geocoder_status : OK
         * types : ["street_address"]
         */

        private String place_id;
        private String geocoder_status;
        private List<String> types;

        public String getPlace_id() {
            return place_id;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public String getGeocoder_status() {
            return geocoder_status;
        }

        public void setGeocoder_status(String geocoder_status) {
            this.geocoder_status = geocoder_status;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }
    }

    public static class RoutesBean {
        /**
         * bounds : {"northeast":{"lat":23.0771609,"lng":72.5180714},"southwest":{"lat":23.0742788,"lng":72.5076035}}
         * copyrights : Map data ©2019
         * legs : [{"distance":{"text":"1.4 km","value":"1406"},"duration":{"text":"17 mins","value":"1041"},"end_address":"Vrundavan Party Plot Rd, Sola, Ahmedabad, Gujarat 380060, India","end_location":{"lat":23.0770711,"lng":72.5180714},"start_address":"A-29, Sola, Ahmedabad, Gujarat 380060, India","start_location":{"lat":23.0771609,"lng":72.5080006},"steps":[{"distance":{"text":"87 m","value":"87"},"duration":{"text":"1 min","value":"60"},"end_location":{"lat":23.0764707,"lng":72.5076035},"html_instructions":"Head <b>southwest<\/b> toward <b>Science City Rd<\/b>","polyline":{"points":"ggzkC_vpyLhCnA"},"start_location":{"lat":23.0771609,"lng":72.5080006},"travel_mode":"WALKING"},{"distance":{"text":"0.5 km","value":"523"},"duration":{"text":"6 mins","value":"380"},"end_location":{"lat":23.0742788,"lng":72.5121291},"html_instructions":"Turn <b>left<\/b> onto <b>Science City Rd<\/b><div style=\"font-size:0.9em\">Pass by Bank of Baroda ATM (on the left in 240&nbsp;m)<\/div>","maneuver":"turn-left","polyline":{"points":"}bzkCospyL`CkGHUBIfCwG`AkCzAyD"},"start_location":{"lat":23.0764707,"lng":72.5076035},"travel_mode":"WALKING"},{"distance":{"text":"0.3 km","value":"340"},"duration":{"text":"5 mins","value":"271"},"end_location":{"lat":23.0769413,"lng":72.5137558},"html_instructions":"Turn <b>left<\/b>","maneuver":"turn-left","polyline":{"points":"guykCyoqyLqCuAkB_AsCwAk@We@[o@c@"},"start_location":{"lat":23.0742788,"lng":72.5121291},"travel_mode":"WALKING"},{"distance":{"text":"0.2 km","value":"205"},"duration":{"text":"2 mins","value":"145"},"end_location":{"lat":23.0768267,"lng":72.5157586},"html_instructions":"Turn <b>right<\/b>","maneuver":"turn-right","polyline":{"points":"{ezkC_zqyLDyADwADy@BcD"},"start_location":{"lat":23.0769413,"lng":72.5137558},"travel_mode":"WALKING"},{"distance":{"text":"9 m","value":"9"},"duration":{"text":"1 min","value":"7"},"end_location":{"lat":23.0767541,"lng":72.5157289},"html_instructions":"Turn <b>right<\/b> onto <b>Bhagwat Vidyapith Rd<\/b>","maneuver":"turn-right","polyline":{"points":"eezkCofryLND"},"start_location":{"lat":23.0768267,"lng":72.5157586},"travel_mode":"WALKING"},{"distance":{"text":"0.2 km","value":"242"},"duration":{"text":"3 mins","value":"178"},"end_location":{"lat":23.0770711,"lng":72.5180714},"html_instructions":"Turn <b>left<\/b><div style=\"font-size:0.9em\">Destination will be on the left<\/div>","maneuver":"turn-left","polyline":{"points":"udzkCifryLMiBGeAOcCGk@QsB"},"start_location":{"lat":23.0767541,"lng":72.5157289},"travel_mode":"WALKING"}],"via_waypoint":[]}]
         * overview_polyline : {"points":"ggzkC_vpyLhCnA`CkGL_@hEcLzAyDqCuA_GwCqAs@o@c@DyAJqCBcDNDUoDWoDQsB"}
         * summary : Science City Rd
         * warnings : ["Walking directions are in beta.    Use caution \u2013 This route may be missing sidewalks or pedestrian paths."]
         * waypoint_order : []
         */

        private BoundsBean bounds;
        private String copyrights;
        private OverviewPolylineBean overview_polyline;
        private String summary;
        private List<LegsBean> legs;
        private List<String> warnings;
        private List<?> waypoint_order;

        public BoundsBean getBounds() {
            return bounds;
        }

        public void setBounds(BoundsBean bounds) {
            this.bounds = bounds;
        }

        public String getCopyrights() {
            return copyrights;
        }

        public void setCopyrights(String copyrights) {
            this.copyrights = copyrights;
        }

        public OverviewPolylineBean getOverview_polyline() {
            return overview_polyline;
        }

        public void setOverview_polyline(OverviewPolylineBean overview_polyline) {
            this.overview_polyline = overview_polyline;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<LegsBean> getLegs() {
            return legs;
        }

        public void setLegs(List<LegsBean> legs) {
            this.legs = legs;
        }

        public List<String> getWarnings() {
            return warnings;
        }

        public void setWarnings(List<String> warnings) {
            this.warnings = warnings;
        }

        public List<?> getWaypoint_order() {
            return waypoint_order;
        }

        public void setWaypoint_order(List<?> waypoint_order) {
            this.waypoint_order = waypoint_order;
        }

        public static class BoundsBean {
            /**
             * northeast : {"lat":23.0771609,"lng":72.5180714}
             * southwest : {"lat":23.0742788,"lng":72.5076035}
             */

            private NortheastBean northeast;
            private SouthwestBean southwest;

            public NortheastBean getNortheast() {
                return northeast;
            }

            public void setNortheast(NortheastBean northeast) {
                this.northeast = northeast;
            }

            public SouthwestBean getSouthwest() {
                return southwest;
            }

            public void setSouthwest(SouthwestBean southwest) {
                this.southwest = southwest;
            }

            public static class NortheastBean {
                /**
                 * lat : 23.0771609
                 * lng : 72.5180714
                 */

                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class SouthwestBean {
                /**
                 * lat : 23.0742788
                 * lng : 72.5076035
                 */

                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }
        }

        public static class OverviewPolylineBean {
            /**
             * points : ggzkC_vpyLhCnA`CkGL_@hEcLzAyDqCuA_GwCqAs@o@c@DyAJqCBcDNDUoDWoDQsB
             */

            private String points;

            public String getPoints() {
                return points;
            }

            public void setPoints(String points) {
                this.points = points;
            }
        }

        public static class LegsBean {
            /**
             * distance : {"text":"1.4 km","value":"1406"}
             * duration : {"text":"17 mins","value":"1041"}
             * end_address : Vrundavan Party Plot Rd, Sola, Ahmedabad, Gujarat 380060, India
             * end_location : {"lat":23.0770711,"lng":72.5180714}
             * start_address : A-29, Sola, Ahmedabad, Gujarat 380060, India
             * start_location : {"lat":23.0771609,"lng":72.5080006}
             * steps : [{"distance":{"text":"87 m","value":"87"},"duration":{"text":"1 min","value":"60"},"end_location":{"lat":23.0764707,"lng":72.5076035},"html_instructions":"Head <b>southwest<\/b> toward <b>Science City Rd<\/b>","polyline":{"points":"ggzkC_vpyLhCnA"},"start_location":{"lat":23.0771609,"lng":72.5080006},"travel_mode":"WALKING"},{"distance":{"text":"0.5 km","value":"523"},"duration":{"text":"6 mins","value":"380"},"end_location":{"lat":23.0742788,"lng":72.5121291},"html_instructions":"Turn <b>left<\/b> onto <b>Science City Rd<\/b><div style=\"font-size:0.9em\">Pass by Bank of Baroda ATM (on the left in 240&nbsp;m)<\/div>","maneuver":"turn-left","polyline":{"points":"}bzkCospyL`CkGHUBIfCwG`AkCzAyD"},"start_location":{"lat":23.0764707,"lng":72.5076035},"travel_mode":"WALKING"},{"distance":{"text":"0.3 km","value":"340"},"duration":{"text":"5 mins","value":"271"},"end_location":{"lat":23.0769413,"lng":72.5137558},"html_instructions":"Turn <b>left<\/b>","maneuver":"turn-left","polyline":{"points":"guykCyoqyLqCuAkB_AsCwAk@We@[o@c@"},"start_location":{"lat":23.0742788,"lng":72.5121291},"travel_mode":"WALKING"},{"distance":{"text":"0.2 km","value":"205"},"duration":{"text":"2 mins","value":"145"},"end_location":{"lat":23.0768267,"lng":72.5157586},"html_instructions":"Turn <b>right<\/b>","maneuver":"turn-right","polyline":{"points":"{ezkC_zqyLDyADwADy@BcD"},"start_location":{"lat":23.0769413,"lng":72.5137558},"travel_mode":"WALKING"},{"distance":{"text":"9 m","value":"9"},"duration":{"text":"1 min","value":"7"},"end_location":{"lat":23.0767541,"lng":72.5157289},"html_instructions":"Turn <b>right<\/b> onto <b>Bhagwat Vidyapith Rd<\/b>","maneuver":"turn-right","polyline":{"points":"eezkCofryLND"},"start_location":{"lat":23.0768267,"lng":72.5157586},"travel_mode":"WALKING"},{"distance":{"text":"0.2 km","value":"242"},"duration":{"text":"3 mins","value":"178"},"end_location":{"lat":23.0770711,"lng":72.5180714},"html_instructions":"Turn <b>left<\/b><div style=\"font-size:0.9em\">Destination will be on the left<\/div>","maneuver":"turn-left","polyline":{"points":"udzkCifryLMiBGeAOcCGk@QsB"},"start_location":{"lat":23.0767541,"lng":72.5157289},"travel_mode":"WALKING"}]
             * via_waypoint : []
             */

            private DistanceBean distance;
            private DurationBean duration;
            private String end_address;
            private EndLocationBean end_location;
            private String start_address;
            private StartLocationBean start_location;
            private List<StepsBean> steps;
            private List<?> via_waypoint;

            public DistanceBean getDistance() {
                return distance;
            }

            public void setDistance(DistanceBean distance) {
                this.distance = distance;
            }

            public DurationBean getDuration() {
                return duration;
            }

            public void setDuration(DurationBean duration) {
                this.duration = duration;
            }

            public String getEnd_address() {
                return end_address;
            }

            public void setEnd_address(String end_address) {
                this.end_address = end_address;
            }

            public EndLocationBean getEnd_location() {
                return end_location;
            }

            public void setEnd_location(EndLocationBean end_location) {
                this.end_location = end_location;
            }

            public String getStart_address() {
                return start_address;
            }

            public void setStart_address(String start_address) {
                this.start_address = start_address;
            }

            public StartLocationBean getStart_location() {
                return start_location;
            }

            public void setStart_location(StartLocationBean start_location) {
                this.start_location = start_location;
            }

            public List<StepsBean> getSteps() {
                return steps;
            }

            public void setSteps(List<StepsBean> steps) {
                this.steps = steps;
            }

            public List<?> getVia_waypoint() {
                return via_waypoint;
            }

            public void setVia_waypoint(List<?> via_waypoint) {
                this.via_waypoint = via_waypoint;
            }

            public static class DistanceBean {
                /**
                 * text : 1.4 km
                 * value : 1406
                 */

                private String text;
                private String value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class DurationBean {
                /**
                 * text : 17 mins
                 * value : 1041
                 */

                private String text;
                private String value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class EndLocationBean {
                /**
                 * lat : 23.0770711
                 * lng : 72.5180714
                 */

                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class StartLocationBean {
                /**
                 * lat : 23.0771609
                 * lng : 72.5080006
                 */

                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class StepsBean {
                /**
                 * distance : {"text":"87 m","value":"87"}
                 * duration : {"text":"1 min","value":"60"}
                 * end_location : {"lat":23.0764707,"lng":72.5076035}
                 * html_instructions : Head <b>southwest</b> toward <b>Science City Rd</b>
                 * polyline : {"points":"ggzkC_vpyLhCnA"}
                 * start_location : {"lat":23.0771609,"lng":72.5080006}
                 * travel_mode : WALKING
                 * maneuver : turn-left
                 */

                private DistanceBeanX distance;
                private DurationBeanX duration;
                private EndLocationBeanX end_location;
                private String html_instructions;
                private PolylineBean polyline;
                private StartLocationBeanX start_location;
                private String travel_mode;
                private String maneuver;

                public DistanceBeanX getDistance() {
                    return distance;
                }

                public void setDistance(DistanceBeanX distance) {
                    this.distance = distance;
                }

                public DurationBeanX getDuration() {
                    return duration;
                }

                public void setDuration(DurationBeanX duration) {
                    this.duration = duration;
                }

                public EndLocationBeanX getEnd_location() {
                    return end_location;
                }

                public void setEnd_location(EndLocationBeanX end_location) {
                    this.end_location = end_location;
                }

                public String getHtml_instructions() {
                    return html_instructions;
                }

                public void setHtml_instructions(String html_instructions) {
                    this.html_instructions = html_instructions;
                }

                public PolylineBean getPolyline() {
                    return polyline;
                }

                public void setPolyline(PolylineBean polyline) {
                    this.polyline = polyline;
                }

                public StartLocationBeanX getStart_location() {
                    return start_location;
                }

                public void setStart_location(StartLocationBeanX start_location) {
                    this.start_location = start_location;
                }

                public String getTravel_mode() {
                    return travel_mode;
                }

                public void setTravel_mode(String travel_mode) {
                    this.travel_mode = travel_mode;
                }

                public String getManeuver() {
                    return maneuver;
                }

                public void setManeuver(String maneuver) {
                    this.maneuver = maneuver;
                }

                public static class DistanceBeanX {
                    /**
                     * text : 87 m
                     * value : 87
                     */

                    private String text;
                    private String value;

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }

                public static class DurationBeanX {
                    /**
                     * text : 1 min
                     * value : 60
                     */

                    private String text;
                    private String value;

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }

                public static class EndLocationBeanX {
                    /**
                     * lat : 23.0764707
                     * lng : 72.5076035
                     */

                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }

                public static class PolylineBean {
                    /**
                     * points : ggzkC_vpyLhCnA
                     */

                    private String points;

                    public String getPoints() {
                        return points;
                    }

                    public void setPoints(String points) {
                        this.points = points;
                    }
                }

                public static class StartLocationBeanX {
                    /**
                     * lat : 23.0771609
                     * lng : 72.5080006
                     */

                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }
            }
        }
    }
}
