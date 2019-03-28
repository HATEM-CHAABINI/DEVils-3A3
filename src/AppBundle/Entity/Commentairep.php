<?php

namespace AppBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Commentairep
 *
 * @ORM\Table(name="commentairep", indexes={@ORM\Index(name="ref_pub", columns={"ref_pub"})})
 * @ORM\Entity
 */
class Commentairep
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="username", type="string", length=60, nullable=false)
     */
    private $username;

    /**
     * @var string
     *
     * @ORM\Column(name="commentaire", type="string", length=600, nullable=false)
     */
    private $commentaire;

    /**
     * @var \Publication
     *
     * @ORM\ManyToOne(targetEntity="Publication")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ref_pub", referencedColumnName="reference")
     * })
     */
    private $refPub;



    /**
     * Get id
     *
     * @return integer
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set username
     *
     * @param string $username
     *
     * @return Commentairep
     */
    public function setUsername($username)
    {
        $this->username = $username;

        return $this;
    }

    /**
     * Get username
     *
     * @return string
     */
    public function getUsername()
    {
        return $this->username;
    }

    /**
     * Set commentaire
     *
     * @param string $commentaire
     *
     * @return Commentairep
     */
    public function setCommentaire($commentaire)
    {
        $this->commentaire = $commentaire;

        return $this;
    }

    /**
     * Get commentaire
     *
     * @return string
     */
    public function getCommentaire()
    {
        return $this->commentaire;
    }

    /**
     * Set refPub
     *
     * @param \AppBundle\Entity\Publication $refPub
     *
     * @return Commentairep
     */
    public function setRefPub(\AppBundle\Entity\Publication $refPub = null)
    {
        $this->refPub = $refPub;

        return $this;
    }

    /**
     * Get refPub
     *
     * @return \AppBundle\Entity\Publication
     */
    public function getRefPub()
    {
        return $this->refPub;
    }
}
