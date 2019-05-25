<?php

namespace BibliothequeBundle\Controller;

use AppBundle\AppBundle;
use AppBundle\Entity\User;
use BibliothequeBundle\Entity\CommentaireLivre;
use BibliothequeBundle\Entity\Livre;
use BibliothequeBundle\Entity\Location;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\SwiftmailerBundle;

/**
 * Livre controller.
 *
 * @Route("livre")
 */
class LivreController extends Controller
{

    /**
     * @Route("/envoieMail", name="EnvoieMail")
     * @Method("GET")
     */
    public function EnvoieMailAction()
    {
        $em = $this->getDoctrine()->getManager();
        $users=$em->getRepository('AppBundle:User')->findAll();
        $location=[];
        $lo=[];
        $livre=new Livre();
        $w=new Location();

        $a=new Location();
        foreach ($users as $u) {
            $l = $em->getRepository('BibliothequeBundle:Location')->LocationValiders($u->getId());
        array_push($lo,$l);
        }

        foreach ($lo as $a){
            foreach ($a as $w) {
                $livre = $em->getRepository("BibliothequeBundle:Livre")->getlivreparid($w->getLivre()->getId());

                $w->setLivre($livre[0]);
              //  $date=new \DateTime($w->getDateRetour());
//                var_dump($w->getDateRetour()->format("Y-m-d"));
//                var_dump(date("Y-m-d"));
//                $w->getDateRetour()->format("Y-m-d")
            if( $w->getDateRetour()->format("Y-m-d")<=date("Y-m-d")){
var_dump($w->getDateRetour()->format("Y-m-d"));
                //                array_push($location,$w);
//                var_dump("aaaaaaaaaaaaaaaaaaaaaaaaaa");

//                var_dump($w);
                $message = (new \Swift_Message())->setSubject('Bonjour Monsieur/Madame '.$w->getLocataire()->getNom())
                    ->setFrom('devilsmailer@gmail.com')
//                    el mail
                    ->setTo($w->getLocataire()->getEmail())
                    ->setBody('vous avez le livre '.$w->getLivre()->getTitre(). ' a Rendre');
                $this->get('mailer')->send($message);
//var_dump($message);
            }}
    }
////////////////
    /*    // Authorisation details.
        $username = "devilsmailer@gmail.com";
        $hash = "de6af941484f70595b2dd121feb5f6a2caa3d2bc6a60fb6a24d29ebf28dd4843";

        // Config variables. Consult http://api.txtlocal.com/docs for more info.
        $test = "0";

        // Data for text message. This is the text message data.
        $sender = "API Test"; // This is who the message appears to be from.
        $numbers = "+216"; // A single number or a comma-seperated list of numbers
        $message = "This is a test message from the PHP API script.";
        // 612 chars or less
        // A single number or a comma-seperated list of numbers
        $message = urlencode($message);
        $data = "username=".$username."&hash=".$hash."&message=".$message."&sender=".$sender."&numbers=".$numbers."&test=".$test;
        $ch = curl_init('http://api.txtlocal.com/send/?');
        curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        $result = curl_exec($ch); // This is the result from the API
        curl_close($ch);

        ///////////////////

        //send tiquet at mail*/

        return $this->redirectToRoute('livre_index');


    }

    /**
     * @Route("/livreValider", name="livreValider")
     * @Method("GET")
     */
    public function ValiderlivreAction()
    {
        $em = $this->getDoctrine()->getManager();
        $p=$this->get('security.token_storage')->getToken()->getUser();
        $search='anon.';


        $livres=null;
        $location=[];
        if(!(preg_match("/{$search}/i",$p))) {

            $lo = $em->getRepository('BibliothequeBundle:Location')->LocationValiders($this->get('security.token_storage')->getToken()->getUser()->getId());
                foreach ($lo as $l){
//            if($l->getDateRetour()>=new \DateTime('now')){
                array_push($location,$l);

//            }
        }
        }
        //        foreach ($location as $lo){
//            $l= $em->getRepository('BibliothequeBundle:Livre')->getlivreparlocation($lo->getId());
//        }
//        array_push($livres,$l);

        return $this->render('location/Locationarendre.html.twig', array(
            'location' => $location,
        ));
    }

    /**
     *
     * @Route("/Commentere/{id}", name="Commenter_le_livre")
     * @Method("GET")
     */
    public function CommenteAction(Request $request, Livre $livre)
    {

        $verif=0;
        $array = array("SALUT", "HATEM");
        var_dump($array);
        $var = $request->get('comment');
        $commentaire = new CommentaireLivre();
        $commentaire->setLocataire($this->get('security.token_storage')->getToken()->getUser());
        $commentaire->setLivre($livre);
        $varm= strtoupper($var);
        $chan=explode(' ',$varm);
        var_dump($chan);
foreach ($array as $a){
        foreach ($chan as $v){
            if($v==$a){
                $verif=1;
                break;
            }
        }
    }
if($verif==0) {
    $commentaire->setCommentaire($var);
    $em = $this->getDoctrine()->getManager();

//        $mailer=$this->container->get('mailer');
//        $transport= \Swift_SmtpTransport::newInstance('smtp.gmail.com',465,'ssl')
//            ->setUsername('pidevils1@gmail.com')
//            ->setPassword('Lessimpson1997');
//        $mailer= \Swift_Mailer::newInstance($transport);
//        $message= \Swift_Message::newInstance('test')
//            ->setSubject('test')
//            ->setFrom('pidevils1@gmail.com')
//            ->setTo('hatemchaabini@gmail.com')
//            ->setBody('test');
//        $this->get('mailer')->send($message);


    $em->persist($commentaire);
    $em->flush();
    $this->addFlash('success', 'succes');

    //    $Comm = $em->getRepository('BibliothequeBundle:CommentaireLivre')->CommentaireLivreId($livre->getId());
}else{
    $this->addFlash('warning', 'Echec Ce commentaire contient des injures et insultes');

}

        return $this->redirectToRoute('livre_commenter', array('id' => $livre->getId()));
//
//        return $this->render('livre/Commenter.html.twig', array(
//            'livre' => $livre,
//            'commentaire'=>$Comm,
//        ));

        //  return $this->redirectToRoute('location_index');
    }

    /**
     * Lists all livre entities.
     *
     * @Route("/", name="livre_index")
     * @Method("GET")
     */
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $livres = $em->getRepository('BibliothequeBundle:Livre')->findAll();

        return $this->render('livre/index.html.twig', array(
            'livres' => $livres,
        ));
    }

    /**
     * Creates a new livre entity.
     *
     * @Route("/new", name="livre_new")
     * @Method({"GET", "POST"})
     */
    public function newAction(Request $request)
    {
        $livre = new Livre();
        $form = $this->createForm('BibliothequeBundle\Form\LivreType', $livre);
        $form->handleRequest($request);
        $v=0;
        if ($form->isSubmitted() && $form->isValid()) {
            /**
             * @var UploadedFile $file
             */
            $file = $livre->getImage();
            if ($file->guessExtension() == 'jpeg' || $file->guessExtension() == 'png' || $file->guessExtension() == 'JPEG' || $file->guessExtension() == 'PNG') {

                $fileName = md5(uniqid()) . '.' . $file->guessExtension();
                $file->move(
                    $this->getParameter('image_directory'), $fileName
                );
                $livre->setImage($fileName);
                $v=$v+1;
            }
            if ($livre->getQuantite()>0){
                $v=$v+1;
            }
            if ($livre->getPrix()>=0){
                $v=$v+1;
            }
            if($v==3) {
                $em = $this->getDoctrine()->getManager();
                $em->persist($livre);
                $em->flush();
                $this->addFlash('success', 'succes');

                return $this->redirectToRoute('livre_show', array('id' => $livre->getId()));
            }
        else{
            $this->addFlash('warning', 'Echec');

             return $this->redirectToRoute('livre_new');
//                return $this->render('livre/new.html.twig', array(
//            'livre' => $livre,
//            'form' => $form->createView(),
//        ));
            }
        }

        return $this->render('livre/new.html.twig', array(
            'livre' => $livre,
            'form' => $form->createView(),
        ));
    }

    /**
     * Finds and displays a livre entity.
     *
     * @Route("/{id}", name="livre_show")
     * @Method("GET")
     */
    public function showAction(Livre $livre)
    {
$p=$this->get('security.token_storage')->getToken()->getUser();
        $search='anon.';

        if(!(preg_match("/{$search}/i",$p))) {

      if ($this->container->get('security.authorization_checker')->isGranted('ROLE_CLIENT')) {
          $deleteForm = $this->createDeleteForm($livre);

          return $this->render('livre/Show.html.twig', array(
              'livre' => $livre,
              'delete_form' => $deleteForm->createView(),
          ));
        } else {
          $deleteForm = $this->createDeleteForm($livre);

          return $this->render('livre/ShowLivreAdmin.html.twig', array(
              'livre' => $livre,
              'delete_form' => $deleteForm->createView(),
          ));

        }
    }else{  $deleteForm = $this->createDeleteForm($livre);

            return $this->render('livre/Show.html.twig', array(
                'livre' => $livre,
                'delete_form' => $deleteForm->createView(),
            ));}
        }

    /**
     *
     * @Route("/commenter/{id}", name="livre_commenter")
     * @Method("GET")
     */
    public function CommenterAction(Request $request, Livre $livre)
    {
        $em = $this->getDoctrine()->getManager();
        $Comm = $em->getRepository('BibliothequeBundle:CommentaireLivre')->CommentaireLivreId($livre->getId());
        return $this->render('livre/Commenter.html.twig', array(
            'livre' => $livre,
            'commentaire' => $Comm,
        ));
    }


    /**
     * Displays a form to edit an existing livre entity.
     *
     * @Route("/{id}/edit", name="livre_edit")
     * @Method({"GET", "POST"})
     */
    public function editAction(Request $request, Livre $livre)
    {
        $deleteForm = $this->createDeleteForm($livre);
        $editForm = $this->createForm('BibliothequeBundle\Form\LivreType', $livre);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {

            /**
             * @var UploadedFile $file
             */
            $file = $livre->getImage();
            if ($file->guessExtension() == 'jpeg' || $file->guessExtension() == 'png' || $file->guessExtension() == 'JPEG' || $file->guessExtension() == 'PNG') {

                $fileName = md5(uniqid()) . '.' . $file->guessExtension();
                $file->move(
                    $this->getParameter('image_directory'), $fileName
                );
                $livre->setImage($fileName);
            }
            $em = $this->getDoctrine()->getManager();
            $em->persist($livre);
            $em->flush();

            return $this->redirectToRoute('livre_show', array('id' => $livre->getId()));
        }
        return $this->render('livre/edit.html.twig', array(
            'livre' => $livre,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Deletes a livre entity.
     *
     * @Route("/{id}", name="livre_delete")
     * @Method("DELETE")
     */
    public function deleteAction(Request $request, Livre $livre)
    {
        $form = $this->createDeleteForm($livre);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($livre);
            $em->flush();
        }

        return $this->redirectToRoute('livre_index');
    }

    /**
     *
     * @Route("/louer/{id}", name="louer_livre")
     * @Method("POST")
     */

    public function louerAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();
        $livre = $em->getRepository("BibliothequeBundle:Livre")->find($id);
        $dated = new \DateTime($request->get("dated"));
        $datef = new \DateTime($request->get("datef"));
        $var=$dated>$datef;
        if ( $livre->getQuantite() > 0 && $dated<$datef)  {
            $livre->setQuantite($livre->getQuantite() - 1);
            $location = new Location();
            $location->setDateLocation($dated);
            $location->setDateRetour($datef);
            $location->setLivre($livre);
            $location->setEtat("En cours");
            $location->setLocataire($this->get('security.token_storage')->getToken()->getUser());
            $em = $this->getDoctrine()->getManager();
            $em->persist($location);
            $em->flush();
            $this->addFlash('success', 'succes');

        } else {
            $this->addFlash('warning', 'Echec Livre indisponnible');

        }
        return $this->redirectToRoute('location_index');
        var_dump($var);
    }


//    /**
//     * Displays a form to edit an existing location entity.
//     *
//     * @Route("/mesLocations", name="meslocations")
//     * @Method({"GET", "POST"})
//     */
//    public function meslocationssAction(Request $request)
//    {
//        $p=$this->get('security.token_storage')->getToken()->getUser();
//        $search='anon.';
//
//        $em = $this->getDoctrine()->getManager();
//            $locations = $this->getDoctrine()->getRepository(Location::class)->Meslocations($this->get('security.token_storage')->getToken()->getUser()->getId());
//
//        return $this->render('location/meslocation.html.twig', array(
//            'location' => $locations,
//        ));
//    }
    /**
     * Creates a form to delete a livre entity.
     *
     * @param Livre $livre The livre entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm(Livre $livre)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('livre_delete', array('id' => $livre->getId())))
            ->setMethod('DELETE')
            ->getForm();
    }
}
